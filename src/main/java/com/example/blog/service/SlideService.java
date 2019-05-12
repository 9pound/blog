package com.example.blog.service;

import com.example.blog.entity.Slide;

import java.util.List;

public interface SlideService {
    List<Slide> getAll();
    void delete(Integer slideId);
    Slide save(Slide slide);
    Slide findBySlideId(Integer slideId);
    List<Slide> findAllBySlideStatus(Integer slideStatus);
}
