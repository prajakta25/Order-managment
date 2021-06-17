package com.egen.service;

import com.egen.exception.BadRequestException;
import com.egen.exception.ResourceNotFoundException;
import com.egen.model.Order;
import com.egen.repository.OrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepositoryImpl orderRepositoryImpl;

    public List<Order> getAllOrders(){
        List<Order> list = orderRepositoryImpl.findAll();
        if(list.size() == 0) {
            throw new ResourceNotFoundException("Order table is empty");
        }
        return list;
    }

    public Order getOrderById(long id){
        return orderRepositoryImpl.getById(id);
    }

    public List<Order> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime){
        //TODO
        return null;
    }

    public List<Order> top10OrdersWithHighestDollarAmountInZip(String zip){
        //TODO
        return null;
    }

    @Transactional
    public Order placeOrder(Order order){
        Order existing = orderRepositoryImpl.create(order);
        if(existing == null) {
            throw new BadRequestException("Order with id " + order.getId() + "already exists");
        }
        return order;
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
        Order existing = orderRepositoryImpl.update(order);
        if(existing == null) {
            throw new ResourceNotFoundException("Order with id " + order.getId() + "does not exist");
        }
        return order;
    }
}
