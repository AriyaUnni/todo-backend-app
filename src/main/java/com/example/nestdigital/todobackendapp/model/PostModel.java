package com.example.nestdigital.todobackendapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class PostModel {
    @Id
    @GeneratedValue
    private int id;
    private int user_id;
    private String post;
    private String posted_date;

    public PostModel() {
    }

    public PostModel(int id, int user_id, String post, String posted_date) {
        this.id = id;
        this.user_id = user_id;
        this.post = post;
        this.posted_date = posted_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }
}
