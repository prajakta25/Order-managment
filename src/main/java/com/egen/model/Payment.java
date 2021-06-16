package com.egen.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "card_number")
    private long cardNumber;

    @Column(name = "payment_confirmation_number")
    private long paymentConfirmationNumber;

    @OneToOne(cascade = {CascadeType.ALL})
    private Address billingAddress;

    public Payment(PaymentMethod paymentMethod, long cardNumber, long paymentConfirmationNumber, Address billingAddress) {
        this.paymentConfirmationNumber = paymentConfirmationNumber;
        this.billingAddress = billingAddress;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
    }

    public Payment() {}

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
