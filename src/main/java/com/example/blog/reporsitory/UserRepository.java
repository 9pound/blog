package com.example.blog.reporsitory;

import com.example.blog.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserEmailAndUserPassword(String userEmail,String userPassword);
    User findByUserId(Integer userId);

}
