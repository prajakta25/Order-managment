package com.egen.repository;

import com.egen.model.Order;
import com.egen.model.OrderStatus;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> query = em.createNamedQuery("Order.findAll",Order.class);
        return query.getResultList();
    }

    @Override
    public Order getById(Long id) {
        return em.find(Order.class,id);
    }

    @Override
    public Order create(Order order) {
        em.persist(order);
        return order;
    }

    @Override
    public Order update(Order order) {
        return em.merge(order);
    }

    @Override
    public void delete(Order order) {
        em.remove(order);
    }

    @Override
    public Order cancel(long id) {
        Query query = em.createQuery("UPDATE Order ord SET ord.status=:stat where ord.id=:oid");
        query.setParameter("stat",OrderStatus.CANCEL);
        query.setParameter("oid",id);
        int r=query.executeUpdate();
        if (r==0) {
            return null;
        }
        return getById(id);
    }

    @Override
    public List<Order> top10OrdersWithHighestDollarAmountInZip(String zip){
        return null;
    }

    @Override
    public List<Order> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Order> findAllById(Iterable<Long> iterable) {
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
    public <S extends Order> S save(S s) {
        return null;
    }

    @Override
    public <S extends Order> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long aLong) {
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
    public <S extends Order> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Order> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Order> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Order getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Order> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Order> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Order> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> iterable) {

    }

    @Override
    public void deleteAll() {

    }


}
