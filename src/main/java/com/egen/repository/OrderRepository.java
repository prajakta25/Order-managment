package com.egen.repository;

import com.egen.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    public List<Order> findAll();
    public Order create(Order order);
    public Order update(Order order);
    public void delete(Order order);
    public Order cancel(long id);
    public List<Order> top10OrdersWithHighestDollarAmountInZip(String zip);
}
