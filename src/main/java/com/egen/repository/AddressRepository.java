package com.egen.repository;

import com.egen.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    public List<Address> findAll();
    public  Address findOne(long id);
    public Address create(Address address);
    public Address update(Address address);
    public void delete(long id);


}
