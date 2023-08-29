package com.jpa.service;

import com.jpa.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IService<Product> {
    void save(Product product, int idCategory);
    Page<Product> getAll(Pageable pageable);
}
