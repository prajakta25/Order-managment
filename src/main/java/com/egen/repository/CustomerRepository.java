package com.egen.repository;

import com.egen.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public List<Customer> findAll();
    public Customer create(Customer cust);
    public Customer update(Customer cust);
    public void delete(long id);
}
