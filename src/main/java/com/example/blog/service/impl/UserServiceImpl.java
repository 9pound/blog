package com.example.blog.service.impl;

import com.example.blog.entity.User;
import com.example.blog.entity.UserRole;
import com.example.blog.reporsitory.RoleRepository;
import com.example.blog.reporsitory.UserRepository;
import com.example.blog.reporsitory.UserRoleRepository;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private UserRoleRepository userRoleRepository;
   @Autowired
   private RoleRepository roleRepository;

   @Override
    public User registerUser(User user) {
        User newUser = userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(newUser.getUserId());
        userRole.setRoleId(2);
        userRoleRepository.save(userRole);
        return newUser;
    }
    @Override
    public User verificationUser(String userEmail,String  userPassword){
        return userRepository.findByUserEmailAndUserPassword(userEmail,userPassword);

    }
    public User findByUserId(Integer userId){
      return userRepository.findByUserId(userId);
    }

    public String getUserRole(Integer userId){
       UserRole userRole  = userRoleRepository.findByUserId(userId);
       return roleRepository.findByRoleId(userRole.getRoleId()).getRoleName();

    }
    public void delete(Integer id){
        userRepository.deleteById(id);
    }

}
