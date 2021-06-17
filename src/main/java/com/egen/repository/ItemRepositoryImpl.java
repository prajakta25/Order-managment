package com.egen.repository;

import com.egen.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ItemRepositoryImpl implements ItemRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Items> findAll() {
        return null;
    }

    @Override
    public Items getById(Long id) {
        return null;
    }

    @Override
    public Items create(Items item) {
        em.persist(item);
        return item;
    }

    @Override
    public Items update(Items item) {
        return em.merge(item);
    }

    @Override
    public void delete(long id) {
        delete(getById(id));
    }

    @Override
    public void delete(Items item) {
        em.remove(item);
    }


    @Override
    public List<Items> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Items> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Items> findAllById(Iterable<Long> iterable) {
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
    public <S extends Items> S save(S s) {
        return null;
    }

    @Override
    public <S extends Items> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Items> findById(Long aLong) {
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
    public <S extends Items> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Items> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Items> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Items getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Items> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Items> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Items> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Items> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Items> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Items> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Items> iterable) {

    }

    @Override
    public void deleteAll() {

    }


}
