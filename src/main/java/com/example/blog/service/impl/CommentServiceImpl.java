package com.example.blog.service.impl;

import com.example.blog.entity.Comment;
import com.example.blog.reporsitory.CommentMongodbRepository;
import com.example.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMongodbRepository commentMongodbRepository;
    @Override
    public List<Comment> getAllCommentByArticleId(String id) {
        return commentMongodbRepository.getAllByArticleId(id);
    }
    public Comment save(Comment comment){
        return commentMongodbRepository.save(comment);
    }
}
