package com.example.readersroom.service;

import java.util.List;

public interface CRUDService<T> {
    List<?> listAll();
    T getById(Long id);
    T saveOrUpdate(T entity);
    void delete(Long id);
}
