package com.example.blog.reporsitory;
import com.example.blog.entity.Role;
import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface RoleRepository extends Repository<Role,Integer> {
    List<Role> findAll();
    @Transactional
    void deleteRoleByRoleId(Integer roleId);
    Role save(Role role);
    Role findByRoleId(Integer roleId);
}
