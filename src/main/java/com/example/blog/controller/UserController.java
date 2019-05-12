package com.example.blog.controller;

import com.example.blog.commons.BlogResult;
import com.example.blog.entity.User;
import com.example.blog.reporsitory.UserRoleRepository;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private UserRoleRepository userRoleRepository;


    @RequestMapping("/login")
    public String login (@RequestParam("user_email") String userEmail,
                         @RequestParam("user_password") String userPassword,
                         HttpSession session
                         ){
        User user = userServiceImpl.verificationUser(userEmail,userPassword);
        if(user != null){
            user.setRole(userServiceImpl.getUserRole(user.getUserId()));
            User sessionUser = (User)session.getAttribute("user");
            if (sessionUser==null)
                session.setAttribute("user",user);
            return "forward:/";
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
    @RequestMapping("/editor")
    @ResponseBody
    public BlogResult update(User user, @RequestParam("userBirthday") String birthday
                             ){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        //加上时间
        //必须捕获异常
        try {
            Date date=simpleDateFormat.parse(birthday);
            user.setUserBirth(date);
        } catch(ParseException px) {
            px.printStackTrace();
        }

        User userUpdate = userServiceImpl.registerUser(user);
        BlogResult blogResult = new BlogResult();
        if(userUpdate != null) {
            blogResult.setStatus(200);
            blogResult.setMessage("操作成功！！！");
        } else {
            blogResult.setStatus(500);
            blogResult.setMessage("操作失败！！！");
        }
        return  blogResult;
    }
    @RequestMapping("/upload")
    public BlogResult uploadImg(@RequestParam("portrait")MultipartFile file,
                                HttpServletRequest request,
                                HttpSession session
    ){
        User user =(User)session.getAttribute("user");
        //上传图片
       // String path=request.getServletContext().getRealPath("/")+"images/portrait/";
        String path ="E:/IdeaProjects/blog/blog/src/main/resources/static/images/portrait/";
        try {
            if (!file.isEmpty()) {
                int random =(int) ((Math.random()+1)*100000);
                String dataStr=new Date().toString().replace(" ","").replace(":","");
                String fileName =random+dataStr+file.getOriginalFilename();
                file.transferTo(new File(path + fileName));
                user.setUserImg("/images/portrait/"+fileName);
                userServiceImpl.registerUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BlogResult blogResult = new BlogResult();
        if(user.getUserImg()!= null) {
            blogResult.setStatus(200);
            blogResult.setMessage("操作成功！！！");
        } else {
            blogResult.setStatus(500);
            blogResult.setMessage("操作失败！！！");
        }
        return  blogResult;
    }
    @RequestMapping("/delete")
    public void delete(@RequestParam("id")Integer id){
        userRoleRepository.deleteByUserId(id);
        userServiceImpl.delete(id);
    }
    //解除用户
    @RequestMapping("/relieve")
    public BlogResult relieve(@RequestParam("id")Integer id){
        User user = userServiceImpl.findByUserId(id);
        //0为不冻结，1为冻结
        user.setUserFreeze(0);
        User result = userServiceImpl.registerUser(user);
        BlogResult blogResult = new BlogResult();
        if (result.getUserFreeze()==0) {
            blogResult.setStatus(200);
            blogResult.setMessage("操作成功！！！");
        } else {
            blogResult.setStatus(500);
            blogResult.setMessage("操作失败！！！");
        }
        return  blogResult;
    }
    //冻结用户
    @RequestMapping("/freeze")
    public BlogResult freeze(@RequestParam("id")Integer id){
        User user = userServiceImpl.findByUserId(id);
        //0为不冻结，1为冻结
        user.setUserFreeze(1);
        User result = userServiceImpl.registerUser(user);
        BlogResult blogResult = new BlogResult();
        if (result.getUserFreeze()==1) {
            blogResult.setStatus(200);
            blogResult.setMessage("操作成功！！！");
        } else {
            blogResult.setStatus(500);
            blogResult.setMessage("操作失败！！！");
        }
        return  blogResult;
    }
    @RequestMapping("/deleteAll")
    public void deleteAll(@RequestParam("ids") String ids){
        String [] id = ids.split("-");
        for(int i = 1;i<id.length;i++){
            userServiceImpl.delete(Integer.parseInt(id[i]));
        }

    }

}
