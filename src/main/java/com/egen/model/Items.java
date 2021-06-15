package com.egen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Items {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private String name;
    private double quantity;
    private double cost;


    public Items(String name, double quantity, double cost) {
        this.id= String.valueOf(UUID.randomUUID());
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Items() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQty() {
        return quantity;
    }

    public void setQty(double quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
