package com.somecompany.datastore.dao;

import java.io.Serializable;
import java.util.List;

public interface Operations<T extends Serializable> {
	T findOne(String id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);

    T delete(T entity);
}
