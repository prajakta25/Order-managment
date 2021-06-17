package com.egen.service;

import com.egen.exception.BadRequestException;
import com.egen.exception.ResourceNotFoundException;
import com.egen.model.Items;
import com.egen.repository.ItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemsService {

    @Autowired
    ItemRepositoryImpl itemRepositoryImpl;

    public List<Items> findAll(){
        List<Items> list = itemRepositoryImpl.findAll();
        if(list.size() == 0) {
            throw new ResourceNotFoundException("Items table is empty");
        }
        return list;
    }

    public Items getById(long id) {
        Items existing = itemRepositoryImpl.getById(id);
        if(existing == null) {
            throw new BadRequestException("Items with id " + id + " does not exists");
        }
        return existing;
    }

    @Transactional
    public Items create(Items item){
        Items existing = itemRepositoryImpl.create(item);
        if(existing == null) {
            throw new BadRequestException("Items with id " + item.getId() + "already exists");
        }
        return existing;
    }

    @Transactional
    public Items update(Items item){
        Items existing = itemRepositoryImpl.update(item);
        if(existing == null) {
            throw new BadRequestException("Items with id " + item.getId() + "does not exists");
        }
        return existing;
    }

    @Transactional
    public void delete(long id){
        try {
            itemRepositoryImpl.delete(id);
        } catch (Exception e) {
            throw new BadRequestException("Items with id " + id + " does not exists");
        }
    }
}
