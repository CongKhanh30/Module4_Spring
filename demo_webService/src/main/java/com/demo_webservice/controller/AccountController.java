package com.demo_webservice.controller;

import com.demo_webservice.model.Account;
import com.demo_webservice.service.AccountService;
import com.demo_webservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id){
        return accountService.findById(id);
    }
    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Account account) {
        accountService.edit(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public List<Account> getAllByName(@PathVariable String name){
        return accountService.getAllByName(name);
    }
    @GetMapping("/login")
    public Account findByUsernamePassWord(@RequestParam String username,@RequestParam String password){
        return accountService.findByUsernamePasswordHQL(username, password);
    }
}
