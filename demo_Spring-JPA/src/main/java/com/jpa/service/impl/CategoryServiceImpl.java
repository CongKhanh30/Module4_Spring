package com.jpa.service.impl;



import com.jpa.model.Category;
import com.jpa.repository.ICategoryRepo;
import com.jpa.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepo iCategoryRepo;


    @Override
    public List<Category> getAll() {
        return (List<Category>) iCategoryRepo.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepo.save(category);
    }

    @Override
    public void edit(Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Category findById(int id) {
        return iCategoryRepo.findById(id).get();
    }
}
