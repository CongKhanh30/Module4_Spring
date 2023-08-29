package com.demo_webservice.repository;

import com.demo_webservice.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<Role, Integer> {
}
