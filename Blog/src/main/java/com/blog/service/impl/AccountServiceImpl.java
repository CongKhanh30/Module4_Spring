package com.blog.service.impl;

import com.blog.model.Account;
import com.blog.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl {
    @Autowired
    IAccountRepo iAccountRepo;

    public Account login(String username, String password){
        return iAccountRepo.login(username,password);
    }
}
