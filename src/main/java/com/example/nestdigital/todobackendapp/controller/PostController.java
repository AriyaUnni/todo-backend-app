package com.example.nestdigital.todobackendapp.controller;

import com.example.nestdigital.todobackendapp.dao.PostDao;
import com.example.nestdigital.todobackendapp.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    @Autowired
    private PostDao dao;

    @PostMapping(path = "/addpost",consumes = "application/json",produces = "application/json")
    public String addPosts(@RequestBody PostModel post){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        post.setPosted_date(currentdate);
        System.out.println(post.toString());
        dao.save(post);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewsingle",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> viewSingle(@RequestBody PostModel view){
        return (List<Map<String, String>>) dao.viewAllSingle(view.getUser_id());
    }

}
