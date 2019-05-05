package com.example.blog.service.impl;

import com.example.blog.entity.Sort;
import com.example.blog.reporsitory.SortRepository;
import com.example.blog.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SortServiceImpl implements SortService {
    @Autowired
    private SortRepository sortRepository;
    public List<Sort> getAll(){
        return sortRepository.findAll();
    }
    public void delete(Integer sortId){

        sortRepository.deleteById(sortId);
    }
    public Sort save(Sort sort){
        return  sortRepository.save(sort);
    }
}
