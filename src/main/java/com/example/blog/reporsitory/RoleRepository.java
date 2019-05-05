package com.example.blog.reporsitory;
import com.example.blog.entity.Role;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RoleRepository extends Repository<Role,Integer> {
    List<Role> findAll();
    void deleteByRoleId(Integer roleId);
    Role save(Role role);
}
