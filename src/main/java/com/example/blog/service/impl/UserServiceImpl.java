package com.example.blog.service.impl;

import com.example.blog.entity.User;
import com.example.blog.reporsitory.UserRepository;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserRepository userRepository;

   @Override
    public User registerUser(User user) {
        User newUser = userRepository.save(user);

        return newUser ;
    }
    @Override
    public User verificationUser(String userEmail,String  userPassword){
        return userRepository.findByUserEmailAndUserPassword(userEmail,userPassword);

    }
    public User findByUserId(Integer userId){
      return userRepository.findByUserId(userId);
    }

}
