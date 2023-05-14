package com.itstep.springapp.daos;

import java.util.List;

public interface Dao<T> {
    void save(T item);
    void edit(T item);
    void delete(T item);
    T getById(int id);
    List<T> getAll();
}
