package com.egen.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    @OneToMany
    private List<Address> addresses;

    @OneToMany
    private List<Payment> paymentMethods;
}
