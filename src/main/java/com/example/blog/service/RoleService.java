package com.example.blog.service;

import com.example.blog.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    void deleteByRoleId(Integer roleId);
    Role save(Role role);
}
