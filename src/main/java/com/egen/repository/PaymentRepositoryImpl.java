package com.egen.repository;

import com.egen.model.Payment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Payment> findAll() {
        return null;
    }

    @Override
    public Payment getById(Long id) {
        return em.find(Payment.class,id);
    }

    @Override
    public Payment create(Payment payment) {
        em.persist(payment);
        return payment;
    }

    @Override
    public Payment update(Payment payment) {
        return em.merge(payment);
    }

    @Override
    public void delete(Payment payment) {
        em.remove(payment);
    }

    @Override
    public List<Payment> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Payment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Payment> findAllById(Iterable<Long> iterable) {
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
    public <S extends Payment> S save(S s) {
        return null;
    }

    @Override
    public <S extends Payment> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Payment> findById(Long aLong) {
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
    public <S extends Payment> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Payment> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Payment> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Payment getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Payment> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Payment> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Payment> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Payment> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Payment> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Payment> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Payment> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
