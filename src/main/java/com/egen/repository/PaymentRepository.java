package com.egen.repository;

import com.egen.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    public List<Payment> findAll();
    public Payment create(Payment payment);
    public Payment update(Payment payment);
    public void delete(Payment payment);
}
