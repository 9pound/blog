package com.example.blog.service.impl;

import com.example.blog.entity.Slide;
import com.example.blog.reporsitory.SlideRepository;
import com.example.blog.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SlideServiceImpl implements SlideService {

    @Autowired
    private SlideRepository slideRepository;


    public List<Slide> getAll() {
        return slideRepository.findAll();
    }


    public void delete(Integer slideId) {
        slideRepository.deleteBySlideId(slideId);
    }


    public Slide save(Slide slide) {
        return slideRepository.save(slide);
    }
}
