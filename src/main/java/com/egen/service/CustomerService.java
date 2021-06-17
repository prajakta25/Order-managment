package com.egen.service;

import com.egen.exception.BadRequestException;
import com.egen.exception.ResourceNotFoundException;
import com.egen.model.Customer;
import com.egen.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepositoryImpl  customerRepositoryImpl;

    public List<Customer> findAll(){
        List<Customer> list = customerRepositoryImpl.findAll();
        if(list.size() == 0) {
            throw new ResourceNotFoundException("Customer table is empty");
        }
        return list;
    }

    public Customer getById(long id) {
        Customer existing = customerRepositoryImpl.getById(id);
        if(existing == null) {
            throw new BadRequestException("Customer with id " + id + " does not exists");
        }
        return existing;
    }

    @Transactional
    public Customer create(Customer cust){
        Customer existing = customerRepositoryImpl.create(cust);
        if(existing == null) {
            throw new BadRequestException("Customer with id " + cust.getId() + "already exists");
        }
        return existing;
    }

    @Transactional
    public Customer update(Customer cust){
        Customer existing = customerRepositoryImpl.update(cust);
        if(existing == null) {
            throw new BadRequestException("Customer with id " + cust.getId() + "already updated");
        }
        return existing;
    }

    @Transactional
    public void delete(long id){
        try {
            customerRepositoryImpl.delete(id);
        } catch (Exception e) {
            throw new BadRequestException("Customer with id " + id + " does not exists");
        }
    }
}
