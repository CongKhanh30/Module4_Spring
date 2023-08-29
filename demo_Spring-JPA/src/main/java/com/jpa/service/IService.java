package com.jpa.service;

import com.jpa.model.Product;

import java.util.List;

public interface IService<E> {
    List<E> getAll();
    void save(E e);
    void edit(E e);
    void delete(int id);
    E findById(int id);
}