package com.example.blog.service;

import com.example.blog.entity.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User verificationUser(String userEmail,String  userPassword);
    User findByUserId(Integer userId);

}
