package com.egen.repository;

import com.egen.model.Customer;
import com.egen.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Items,Long> {
    public List<Items> findAll();
    public Items create(Items item);
    public Items update(Items item);
    public void delete(Items item);
}
