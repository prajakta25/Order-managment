package com.egen.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "order_status")
    private OrderStatus status;

    @Column(name = "customer_id")
    private long customerId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<Items> items;

    @Column(name = "subtotal")
    private double subtotal;

    @Column(name = "tax")
    private double tax;

    @Column(name = "shipping_charges")
    private double shippingCharges;

    @Column(name = "total")
    private double total;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<Payment> paymentMethods;

    @Column(name = "shipping_method")
    private ShippingMethod shippingMethod;

    @OneToOne(cascade = {CascadeType.ALL})
    private Address shippingAddress;

    public Order(){}

    public Order(OrderStatus status, List<Items> items, double tax, double shippingCharges, Timestamp createdDate, Timestamp modifiedDate, List<Payment> paymentMethods, ShippingMethod shippingMethod, Address shippingAddress) {
        this.status = status;
        this.items = items;
        this.tax = tax;
        this.shippingCharges = shippingCharges;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.paymentMethods = paymentMethods;
        this.shippingMethod = shippingMethod;
        this.shippingAddress = shippingAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
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
            subtotal=subtotal + ((item.getCost())* (item.getQuantity()));
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
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<Payment> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<Payment> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }


    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
