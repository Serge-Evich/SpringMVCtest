package com.somecompany.datastore.dao;

import java.io.Serializable;
import java.util.List;

public interface DataStore<T extends Serializable> {

    T get(String id);
    List<T> getByName(String name);
    List<T> getAll();
    void save(T pojo);
    void update(T pojo);
    T remove(T pojo);

}
