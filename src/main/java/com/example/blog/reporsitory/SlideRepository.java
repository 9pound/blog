package com.example.blog.reporsitory;

import com.example.blog.entity.Slide;
import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface SlideRepository extends Repository<Slide,Integer> {
    List<Slide> findAll();
    @Transactional
    void deleteBySlideId(Integer slideId);
    Slide save(Slide slide);
    Slide findBySlideId(Integer slideId);
    List<Slide> findAllBySlideStatus(Integer slideStatus);
}
