package com.egen.controller;

import com.egen.model.Order;
import com.egen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("order")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long id){
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    public ResponseEntity<List<Order>> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime){
        //TODO
        return null;
    }

    public ResponseEntity<List<Order>> top10OrdersWithHighestDollarAmountInZip(String zip){
        //TODO
        return null;
    }

    @PostMapping("order")
    public ResponseEntity<Order> placeOrder(@RequestBody  Order order){
        Order obj = orderService.placeOrder(order);
        return ResponseEntity.ok(obj);
    }


    @DeleteMapping("order/{id}")
    public ResponseEntity<Order> cancelOrder(@PathVariable("id") long id){
        return ResponseEntity.ok(orderService.cancelOrder(id));
    }

    @PutMapping("order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id,  @RequestBody Order order){
        return  ResponseEntity.ok(orderService.updateOrder(order));
    }
}
