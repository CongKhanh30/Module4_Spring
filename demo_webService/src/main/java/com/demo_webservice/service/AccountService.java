package com.demo_webservice.service;

import com.demo_webservice.model.Account;
import com.demo_webservice.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccountRepo iAccountRepo;


    public List<Account> getAll(){
        return (List<Account>) iAccountRepo.findAll();
    }
    public Account findById(int id){
        return iAccountRepo.findById(id).get();
    }

    public Account save(Account account){
        return iAccountRepo.save(account);
    }

    public void edit(Account account) {
        iAccountRepo.save(account);
    }

    public void delete(int id) {
        iAccountRepo.deleteById(id);
    }

    public List<Account> getAllByName(String name){
        return iAccountRepo.getAllByNameHQL(name);
    }
    public Account findByUsernamePasswordHQL(String name, String password){
        return iAccountRepo.findByUsernamePasswordHQL(name, password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(username,account.getPassword(),roles);
    }
}