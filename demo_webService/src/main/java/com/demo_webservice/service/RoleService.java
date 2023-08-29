package com.demo_webservice.service;

import com.demo_webservice.model.Role;
import com.demo_webservice.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private IRoleRepo iRoleRepo;

    public Role findById(int id){
        return iRoleRepo.findById(id).get();
    }
}