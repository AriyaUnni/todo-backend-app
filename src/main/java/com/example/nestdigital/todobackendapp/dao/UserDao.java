package com.example.nestdigital.todobackendapp.dao;

import com.example.nestdigital.todobackendapp.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `dob`, `email`, `name`, `password`, `phone`, `place` FROM `users` WHERE `email`=:email  AND `password`=:password",nativeQuery = true)
    List<UserModel> Signup(String email,String password);
}
