package com.example.blog.reporsitory;

import com.example.blog.entity.Slide;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SlideRepository extends Repository<Slide,Integer> {
    List<Slide> findAll();
    void deleteBySlideId(Integer slideId);
    Slide save(Slide slide);
}
