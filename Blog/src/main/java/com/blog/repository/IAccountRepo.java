package com.blog.repository;

import com.blog.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    Account findByUsernameAndPassword(String username, String password);

    @Query(nativeQuery = true, value = "select * from account where username=:username and password=:password")
    Account login(@Param("username") String username,@Param("password") String password);

}
