package com.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dao<T> {

    T get(int id);

    List<T> getAll();

    void persist(T t);

    void update(T t);

    void delete(T t);
}