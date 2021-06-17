package com.egen.service;

import com.egen.exception.BadRequestException;
import com.egen.exception.ResourceNotFoundException;
import com.egen.model.Items;
import com.egen.model.Order;
import com.egen.model.Payment;
import com.egen.repository.OrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepositoryImpl orderRepositoryImpl;

    @Autowired
    ItemsService itemsService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    AddressService addressService;

    public List<Order> getAllOrders(){
        List<Order> list = orderRepositoryImpl.findAll();
        if(list.size() == 0) {
            throw new ResourceNotFoundException("Order table is empty");
        }
        return list;
    }

    public Order getOrderById(long id){
        Order existing = orderRepositoryImpl.getById(id);
        if(existing == null) {
            throw new BadRequestException("Order with id " + id + " does not exists");
        }
        return existing;
    }

    public List<Order> getAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime){
        List<Order> orderList = orderRepositoryImpl.getAllOrdersWithInInterval(startTime,endTime);
        if(orderList.isEmpty()) {
            throw new BadRequestException("Invalid time interval : "+startTime +" - "+endTime);
        }
        return orderList;
    }

    public List<Order> top10OrdersWithHighestDollarAmountInZip(String zip){
        List<Order> orderList = orderRepositoryImpl.top10OrdersWithHighestDollarAmountInZip(zip);
        if(orderList.isEmpty()) {
            throw new BadRequestException(zip + " does not exists");
        }
        return orderList;
    }

    @Transactional
    public Order placeOrder(Order order){

        //create items
        List<Items> item=order.getItems();
        for(Items it : item) {
            itemsService.create(it);
        }

        //create payment method
        List<Payment> paymentsList = order.getPayment();
        for(Payment paymnt : paymentsList) {
            paymentService.create(paymnt);
        }

        //create address
        addressService.create(order.getShippingAddress());

        Order existing = orderRepositoryImpl.create(order);
        if(existing == null) {
            throw new BadRequestException("Order with id " + order.getId() + "already exists");
        }
        return existing;
    }

    @Transactional
    public Order cancelOrder(long id){
        Order existing = orderRepositoryImpl.cancel(id);
        if(existing == null) {
            throw new ResourceNotFoundException("Order with id " + id+ "has already been canceled");
        }
        return existing;
    }

    @Transactional
    public Order updateOrder(Order order){

        //create items
        List<Items> item=order.getItems();
        for(Items it : item) {
            itemsService.update(it);
        }

        //create payment method
        List<Payment> paymentsList = order.getPayment();
        for(Payment paymnt : paymentsList) {
            paymentService.update(paymnt);
        }

        //create address
        addressService.update(order.getShippingAddress());

        Order existing = orderRepositoryImpl.update(order);
        if(existing == null) {
            throw new ResourceNotFoundException("Order with id " + order.getId() + "does not exist");
        }
        return order;
    }
}
