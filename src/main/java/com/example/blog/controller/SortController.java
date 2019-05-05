package com.example.blog.controller;

import com.example.blog.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/sort")
public class SortController {
    @Autowired
    private SortService sortServiceImpl;
    @RequestMapping(value = "delete")
    public void delete(Integer roleId){
        sortServiceImpl.delete(roleId);
    }
}
