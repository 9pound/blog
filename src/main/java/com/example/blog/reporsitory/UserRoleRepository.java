package com.example.blog.reporsitory;

import com.example.blog.entity.UserRole;
import org.springframework.data.repository.Repository;


public interface UserRoleRepository extends Repository<UserRole,Integer> {
    UserRole findByUserId(Integer userId);

}
