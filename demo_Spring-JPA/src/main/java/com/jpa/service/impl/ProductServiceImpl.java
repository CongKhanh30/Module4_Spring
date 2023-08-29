package com.jpa.service.impl;

import com.jpa.model.Category;
import com.jpa.model.Product;
import com.jpa.repository.ICategoryRepo;
import com.jpa.repository.IProductRepo;
import com.jpa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ICategoryRepo iCategoryRepo;

    @Autowired
    IProductRepo iProductRepo;

    @Override
    public List<Product> getAll() {
        return (List<Product>) iProductRepo.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void edit(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void delete(int id) {
        iProductRepo.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        Optional<Product> optionalProduct = iProductRepo.findById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        } else {
            return new Product();
        }
    }

    @Override
    public void save(Product product, int idCategory) {
        Category category = iCategoryRepo.findById(idCategory).get();
        product.setCategory(category);
        iProductRepo.save(product);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }
}
