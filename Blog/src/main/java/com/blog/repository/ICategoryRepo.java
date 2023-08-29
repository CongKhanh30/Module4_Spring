package com.blog.repository;

import com.blog.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Category, Integer> {
}
