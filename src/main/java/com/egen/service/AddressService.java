package com.egen.service;

import com.egen.exception.BadRequestException;
import com.egen.exception.ResourceNotFoundException;
import com.egen.model.Address;
import com.egen.repository.AddressRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepositoryImpl addressRepositoryImpl;


    public List<Address> findAll() {
        List<Address> list = addressRepositoryImpl.findAll();
        if(list.size() == 0) {
            throw new ResourceNotFoundException("Address table is empty");
        }
        return list;
    }
    public Address getById(Long id) {
        Address existing = addressRepositoryImpl.getById(id);
        if(existing == null) {
            throw new BadRequestException("Address with id " + id + " does not exists");
        }
        return existing;
    }

    @Transactional
    public Address create(Address address) {
        Address existing = addressRepositoryImpl.create(address);
        if(existing == null) {
            throw new BadRequestException("Address with id " + address.getId() + "already exists");
        }
        return existing;
    }

    @Transactional
    public Address update(Address address) {
        Address existing = addressRepositoryImpl.update(address);
        if(existing == null) {
            throw new BadRequestException("Address with id " + address.getId() + "already updated");
        }
        return existing;
    }

    @Transactional
    public void delete(long id){
        try {
        addressRepositoryImpl.delete(id);
        } catch (Exception e) {
            throw new BadRequestException("Address with id " + id + " does not exists");
        }
    }
}
