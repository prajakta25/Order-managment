package com.egen.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private String status;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<Items> items;
    private double subtotal;
    private double tax;
    private double shippingCharges;
    private double total;
    private long paymentConfirmationNumber;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    @OneToMany
    private List<Payment> paymentMethods;
    private String shippingMethod;

    public Order(){}

    public Order(String id, String status, Customer customer, List<Items> items, double tax, double shippingCharges, long paymentConfirmationNumber, LocalDateTime createdDate, LocalDateTime modifiedDate, List<Payment> paymentMethods, String shippingMethod) {
        this.id = id;
        this.status = status;
        this.customer = customer;
        this.items = items;
        this.tax = tax;
        this.shippingCharges = shippingCharges;
        this.paymentConfirmationNumber = paymentConfirmationNumber;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.paymentMethods = paymentMethods;
        this.shippingMethod = shippingMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public double getSubtotal() {
        double subtotal=0.0d;
        List<Items> items=getItems();
        for(Items item: items) {
            subtotal=subtotal + ((item.getCost())* (item.getQty()));
        }
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(double shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    public double getTotal() {
        double total=getSubtotal()+getTax()+getShippingCharges();
        return total;
    }

    public long getPaymentConfirmationNumber() {
        return paymentConfirmationNumber;
    }

    public void setPaymentConfirmationNumber(long paymentConfirmationNumber) {
        this.paymentConfirmationNumber = paymentConfirmationNumber;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<Payment> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<Payment> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
