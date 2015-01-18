package com.somecompany.datastore.dao;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T extends Serializable> implements Operations<T> {
	

    public T findOne(String id) {
        return getDataStore().get(id);
    }

    public List<T> findAll() {
       return getDataStore().getAll();
    }

    public void create(T pojo) {
        getDataStore().save(pojo);
    }

    public void update(T pojo) {
        getDataStore().update(pojo);
    }

    public T delete(T pojo) {
        return getDataStore().remove(pojo);
    }

    protected abstract DataStore<T> getDataStore();
}