package com.example.blog.controller;

import com.example.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleServiceImpl;
    @RequestMapping(value = "/delete")
    public void delete(@RequestParam("id") Integer id){
        roleServiceImpl.deleteByRoleId(id);
    }
}
