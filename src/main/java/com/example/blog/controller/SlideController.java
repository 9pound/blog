package com.example.blog.controller;

import com.example.blog.commons.BlogResult;
import com.example.blog.commons.PrefixID;
import com.example.blog.entity.Slide;
import com.example.blog.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@Controller
@RequestMapping("/slide")
public class SlideController {
    @Autowired
    private SlideService slideServiceImpl;
    //删除单个图片
    @RequestMapping("/delete")
    public void delete(Integer slideId){
        slideServiceImpl.delete(slideId);
    }
    //删除多个图片
    @RequestMapping("/deleteAll")
    public void deleteAll(@RequestParam("ids") String ids){
        String [] id = ids.split("-");
        for(int i = 1;i<id.length;i++)
            slideServiceImpl.delete(Integer.parseInt(id[i]));

    }
    //巨幕上传,与编辑
    @RequestMapping("/save")
    @ResponseBody
    public BlogResult save(
                           Slide slide,
                           @RequestParam("img")MultipartFile file){
        String path ="E:/IdeaProjects/blog/blog/src/main/resources/static/images/featured-posts/";

        if(slide.getSlideId()!=null) {
            Slide exitSlide = slideServiceImpl.findBySlideId(slide.getSlideId());
            exitSlide.setSlideTitle(slide.getSlideTitle());
            exitSlide.setSlideLink(slide.getSlideLink());
            slide = exitSlide;
        }
        try {
            if (!file.isEmpty()) {
                String fileName =PrefixID.getPre()+file.getOriginalFilename();
                file.transferTo(new File(path + fileName));
                slide.setSlideImg("/images/featured-posts/"+fileName);
                slide=slideServiceImpl.save(slide);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BlogResult blogResult = new BlogResult();
        if(slide.getSlideImg()!= null) {
            blogResult.setStatus(200);
            blogResult.setMessage("操作成功！！！");
        } else {
            blogResult.setStatus(500);
            blogResult.setMessage("操作失败！！！");
        }
        return  blogResult;
    }
//巨幕的开启或关闭
    @RequestMapping("/status")
    @ResponseBody
    public void changeStatus(@RequestParam("slideId") Integer slideId,
                                   @RequestParam("slideStatus")Integer slideStatus)
    {
        Slide slide = slideServiceImpl.findBySlideId(slideId);
        slide.setSlideStatus(slideStatus);
        slideServiceImpl.save(slide);
    }
}
