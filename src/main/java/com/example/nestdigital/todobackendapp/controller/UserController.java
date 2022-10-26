package com.example.nestdigital.todobackendapp.controller;

import com.example.nestdigital.todobackendapp.dao.UserDao;
import com.example.nestdigital.todobackendapp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signup",consumes = "application/json",produces = "application/json")
    public String addUser(@RequestBody UserModel add){
        System.out.println(add.toString());
        dao.save(add);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<UserModel> Login(@RequestBody UserModel login){
        return dao.Signup(login.getEmail(),login.getPassword());
    }
}
