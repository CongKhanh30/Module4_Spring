package com.blog.service.impl;

import com.blog.model.Category;
import com.blog.model.Blog;
import com.blog.repository.ICategoryRepo;
import com.blog.repository.IBlogRepo;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    ICategoryRepo iCategoryRepo;
    @Autowired
    IBlogRepo iBlogRepo;

    @Override
    public void save(Blog blog) {
        iBlogRepo.save(blog);
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepo.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepo.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        Optional<Blog> optionalBlog = iBlogRepo.findById(id);
        if (optionalBlog.isPresent()) {
            return optionalBlog.get();
        } else {
            return new Blog();
        }
    }

    @Override
    public List<Blog> getAll() {
        return (List<Blog>) iBlogRepo.findAll();
    }

    @Override
    public void save(Blog blog, int idCategory) {
        Category category = iCategoryRepo.findById(idCategory).get();
        blog.setCategory(category);
        iBlogRepo.save(blog);
    }

    @Override
    public Page<Blog> getAll(Pageable pageable, String nameSearch) {
        return null;
    }
}
