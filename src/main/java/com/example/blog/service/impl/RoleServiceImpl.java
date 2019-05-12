package com.example.blog.service.impl;

import com.example.blog.entity.Role;
import com.example.blog.reporsitory.RoleRepository;
import com.example.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteByRoleId(Integer roleId) {
        roleRepository.deleteRoleByRoleId(roleId);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
