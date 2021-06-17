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
import java.sql.Timestamp;
import java.time.ZonedDateTime;
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
        order.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        order.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        em.persist(order);
        return order;
    }

    @Override
    public Order update(Order order) {
        order.setModifiedDate(new Timestamp(System.currentTimeMillis()));
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
        Query query = em.createQuery("SELECT ord FROM Order ord JOIN Address add ON ord.shippingAddress.id=add.id WHERE add.zip=:paramZip ORDER BY ord.total DESC");
        query.setParameter("paramZip",zip);
        List<Order> list=query.setMaxResults(10).getResultList();
        return list;
    }

    @Override
    public List<Order> getAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime){
        Query query = em.createQuery("SELECT ord FROM Order ord  WHERE ord.createdDate BETWEEN :ordStartTime AND :ordEndTime");
        query.setParameter("ordStartTime",startTime);
        query.setParameter("ordEndTime",endTime);
        List<Order> list=query.getResultList();
        return list;
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
