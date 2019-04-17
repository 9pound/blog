package com.example.blog.controller;

import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userServiceImpl;


    @RequestMapping("/login")
    public String login (@RequestParam("user_email") String userEmail,
                         @RequestParam("user_password") String userPassword,
                         HttpServletRequest request
                         ){
        User user = userServiceImpl.verificationUser(userEmail,userPassword);
        if(user != null){
            HttpSession session = request.getSession();
            User sessionUser = (User)session.getAttribute("user");
            if (sessionUser==null)
                session.setAttribute("user", user);
            return "index";
        } else {

            return "login";
        }


    }

    @RequestMapping("/register")
    public String register (@RequestParam("user_name") String userName,
                            @RequestParam("user_email") String userEmail,
                            @RequestParam("user_password") String userPassword
                            ) {
        User user = new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setUserPassword(userPassword);
        userServiceImpl.registerUser(user);

        return "index";
    }
}
