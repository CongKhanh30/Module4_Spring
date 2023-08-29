package com.blog.service.impl;

import com.blog.model.Category;
import com.blog.repository.ICategoryRepo;
import com.blog.repository.IBlogRepo;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    IBlogRepo iBlogRepo;
    @Autowired
    ICategoryRepo iCategoryRepo;
    @Override
    public void save(Category category) {

    }

    @Override
    public void edit(Category category) {

    }

    @Override
    public void delete(int id) {
        iBlogRepo.deleteById(id);
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) iCategoryRepo.findAll();
    }
}
