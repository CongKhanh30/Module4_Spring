package com.blog.service;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IService<Blog>{
    void save(Blog blog, int idCategory);
    Page<Blog> getAll(Pageable pageable, String nameSearch);
}
