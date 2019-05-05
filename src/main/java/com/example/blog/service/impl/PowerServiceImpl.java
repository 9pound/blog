package com.example.blog.service.impl;

import com.example.blog.entity.Power;
import com.example.blog.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerRepository powerRepository;
    @Override
    public List<Power> findAll() {

        return null;
    }
}
