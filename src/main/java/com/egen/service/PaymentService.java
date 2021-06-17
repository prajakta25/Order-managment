package com.egen.service;

import com.egen.exception.BadRequestException;
import com.egen.exception.ResourceNotFoundException;
import com.egen.model.Items;
import com.egen.model.Payment;
import com.egen.repository.PaymentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepositoryImpl paymentRepositoryImpl;

    public List<Payment> findAll(){
        List<Payment> list = paymentRepositoryImpl.findAll();
        if(list.size() == 0) {
            throw new ResourceNotFoundException("Payment table is empty");
        }
        return list;
    }

    public Payment getById(long id) {
        Payment existing = paymentRepositoryImpl.getById(id);
        if(existing == null) {
            throw new BadRequestException("Payment with id " + id + " does not exists");
        }
        return existing;
    }

    @Transactional
    public Payment create(Payment payment){
        Payment existing = paymentRepositoryImpl.create(payment);
        if(existing == null) {
            throw new BadRequestException("Payment with id " + payment.getId() + "already exists");
        }
        return existing;
    }

    @Transactional
    public Payment update(Payment payment){
        Payment existing = paymentRepositoryImpl.update(payment);
        if(existing == null) {
            throw new BadRequestException("Payment with id " + payment.getId() + " is up to date.");
        }
        return existing;
    }

    @Transactional
    public void delete(long id){
        try {
            paymentRepositoryImpl.delete(id);
        } catch (Exception e) {
            throw new BadRequestException("Payment with id " + id + " does not exists");
        }
    }
}
