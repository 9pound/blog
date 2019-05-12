package com.example.blog.entity;


import javax.persistence.*;

@Entity
@Table(name="slide")
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer slideId;
    private String slideImg="/images/featured-posts/1.jpg";
    private String slideLink="管理员很懒还没有添加...";
    private String slideTitle="管理员很懒还没有添加...";
    //0为开启，1为关闭
    private Integer slideStatus=0;

    public Integer getSlideId() {
        return slideId;
    }

    public void setSlideId(Integer slideId) {
        this.slideId = slideId;
    }

    public String getSlideImg() {
        return slideImg;
    }

    public void setSlideImg(String slideImg) {
        this.slideImg = slideImg;
    }

    public String getSlideLink() {
        return slideLink;
    }

    public void setSlideLink(String slideLink) {
        this.slideLink = slideLink;
    }

    public String getSlideTitle() {
        return slideTitle;
    }

    public void setSlideTitle(String slideTitle) {
        this.slideTitle = slideTitle;
    }

    public Integer getSlideStatus() {
        return slideStatus;
    }

    public void setSlideStatus(Integer slideStatus) {
        this.slideStatus = slideStatus;
    }
}
