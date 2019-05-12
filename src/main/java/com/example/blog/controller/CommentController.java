package com.example.blog.controller;

import com.example.blog.commons.BlogResult;
import com.example.blog.entity.Comment;
import com.example.blog.entity.User;
import com.example.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping(value="/comment")
public class CommentController {
    @Autowired
    private CommentService commentServiceImpl;

    @RequestMapping(value="/leave")
    @ResponseBody
    public BlogResult publishComment(Comment comment, HttpSession session){
        User user = (User) session.getAttribute("user");
        //发表评论用户的Id
        comment.setUserId(user.getUserId());
        //发表用户评论的名称
        comment.setUserName(user.getUserName());
        //发表评论用户的头像
        comment.setImgUrl(user.getUserImg());
        //品论发表的时间
        comment.setCommentDate(new Date());

        Comment commentResult = commentServiceImpl.save(comment);
        BlogResult blogResult = new BlogResult();
        if (commentResult.getId()!=null) {
            blogResult.setId(commentResult.getId());
            blogResult.setMessage("保存成功！！！");
            blogResult.setStatus(200);
        } else {
            blogResult.setMessage("保存失败！！！");
            blogResult.setStatus(500);
        }
        return  blogResult;
    }
}
