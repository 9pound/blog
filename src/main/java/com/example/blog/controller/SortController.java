package com.example.blog.controller;

import com.example.blog.commons.BlogResult;
import com.example.blog.entity.Sort;
import com.example.blog.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/sort")
public class SortController {
    @Autowired
    private SortService sortServiceImpl;
    @RequestMapping(value = "/delete")
    public void delete(@RequestParam("id") Integer roleId){
        sortServiceImpl.delete(roleId);
    }
    //删除多个角色
    @RequestMapping("/deleteAll")
    public void deleteAll(@RequestParam("ids") String ids){
        String [] id = ids.split("-");
        for(int i = 1;i<id.length;i++)
            sortServiceImpl.delete(Integer.parseInt(id[i]));

    }
    //角色保存和编辑都走这个方法
    @RequestMapping("/save")
    @ResponseBody
    public BlogResult save(Sort sort){
        Sort result=sortServiceImpl.save(sort);
        BlogResult blogResult = new BlogResult();
        if (result.getSortId()!=null) {
            blogResult.setStatus(200);
            blogResult.setMessage("操作成功！！！");
        } else {
            blogResult.setStatus(500);
            blogResult.setMessage("操作失败！！！");
        }
        return  blogResult;
    }

}
