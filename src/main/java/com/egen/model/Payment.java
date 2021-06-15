package com.egen.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Payment {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private String paymentMethod;
    private long cardNumber;
    private int cvv;
    private String expiry;
    private long paymentConfirmationNumber;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Address billingAddress;

    public Payment(String id, String paymentMethod, long cardNumber, int cvv, String expiry, long paymentConfirmationNumber, Customer customer, Address billingAddress) {
        this.paymentConfirmationNumber = paymentConfirmationNumber;
        this.customer = customer;
        this.billingAddress = billingAddress;
        this.id = String.valueOf(UUID.randomUUID());
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiry = expiry;
    }

    public Payment() {}

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getPaymentConfirmationNumber() {
        return paymentConfirmationNumber;
    }

    public void setPaymentConfirmationNumber(long paymentConfirmationNumber) {
        this.paymentConfirmationNumber = paymentConfirmationNumber;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}
