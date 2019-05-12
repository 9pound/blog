package com.example.blog.controller;

import com.example.blog.commons.BlogResult;
import com.example.blog.entity.Role;
import com.example.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleServiceImpl;
    //删除单个角色
    @RequestMapping(value = "/delete")
    public void delete(@RequestParam("id") Integer id){

        roleServiceImpl.deleteByRoleId(id);
    }
    //删除多个角色
    @RequestMapping("/deleteAll")
    public void deleteAll(@RequestParam("ids") String ids){
        String [] id = ids.split("-");
        for(int i = 1;i<id.length;i++){
            roleServiceImpl.deleteByRoleId(Integer.parseInt(id[i]));
        }

    }
    //角色保存和编辑都走这个方法
    @RequestMapping("/save")
    @ResponseBody
    public BlogResult save(Role role){
        if(role.getRoleValid()==null)
            role.setRoleValid(0);
        if(role.getRoleDate()==null)
            role.setRoleDate(new Date());
        Role result=roleServiceImpl.save(role);
        BlogResult blogResult = new BlogResult();
        if (result.getRoleId()!=null) {
            blogResult.setStatus(200);
            blogResult.setMessage("操作成功！！！");
        } else {
            blogResult.setStatus(500);
            blogResult.setMessage("操作失败！！！");
        }
        return  blogResult;
    }


}
