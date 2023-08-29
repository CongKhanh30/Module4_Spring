package com.jpa.repository;

import com.jpa.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Category,Integer> {
}