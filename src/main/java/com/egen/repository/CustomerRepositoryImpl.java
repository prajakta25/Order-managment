package com.egen.repository;

import com.egen.model.Customer;
import com.egen.model.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll",Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer getById(Long aLong) {
        return null;
    }

    @Override
    public Customer create(Customer cust) {
        em.persist(cust);
        return null;
    }

    @Override
    public Customer update(Customer cust) {
        return em.merge(cust);
    }


    @Override
    public void delete(Customer cust) {
        em.remove(cust);
    }

    @Override
    public List<Customer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Customer> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Customer> S save(S s) {
        return null;
    }

    @Override
    public <S extends Customer> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Customer> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Customer> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Customer getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Customer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Customer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Customer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Customer> boolean exists(Example<S> example) {
        return false;
    }
}
