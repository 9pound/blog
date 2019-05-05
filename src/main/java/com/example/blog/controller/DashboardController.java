package com.example.blog.controller;

import com.example.blog.commons.Paging;
import com.example.blog.entity.*;
import com.example.blog.reporsitory.RoleRepository;
import com.example.blog.reporsitory.UserJpaRepository;
import com.example.blog.reporsitory.UserRoleRepository;
import com.example.blog.service.*;
import com.example.blog.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value="/dashboard")
public class DashboardController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private ArticleService articleServiceImpl;
    @Autowired
    private SortService sortServiceImpl;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private  SlideService slideServiceImpl;

    @RequestMapping(value="/user-manager")
    public ModelAndView userManager(HttpSession session){
        User currentUser = (User)session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        //加载用户信息
        User user = userServiceImpl.findByUserId(currentUser.getUserId());
        modelAndView.addObject("user",user);
        //用户文章分页
        PageRequest pageRequest = PageRequest.of(0,100);
        Page<Article> page = articleServiceImpl.pagingArticle(user.getUserId(),pageRequest);
        Paging<Article> paging = new Paging<>();
        paging.setList(page.getContent());
        paging.setTotalElements((int)page.getTotalElements());
        modelAndView.addObject("page",paging);
        //用户个人分类加载
        List<Category> categoryList = categoryService.findAllByUserId(user.getUserId());
        modelAndView.addObject("categories",categoryList);
        modelAndView.setViewName("dashboard");

        return modelAndView;
    }
    @RequestMapping("/admin")
    public ModelAndView admin(){
        List<User> users = userJpaRepository.findAll();
        List<Sort> sorts = sortServiceImpl.getAll();
        List<Role> roles = roleRepository.findAll();
        List<Slide> slides = slideServiceImpl.getAll();

        HashMap<Integer,String> roleMap = new HashMap<>();
        for(Role role : roles){
            roleMap.put(role.getRoleId(),role.getRoleName());
        }
        for(User user : users){
            UserRole userRole = userRoleRepository.findByUserId(user.getUserId());
            if(userRole != null)
            user.setRole(roleMap.get(userRole.getRoleId()));

        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",users);
        modelAndView.addObject("sorts",sorts);
        modelAndView.addObject("roles",roles);
        modelAndView.addObject("slides",slides);

        modelAndView.setViewName("admin");
        return modelAndView;
    }






}
