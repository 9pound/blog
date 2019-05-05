package com.example.blog.entity;


import javax.persistence.*;

@Entity
@Table(name="slide")
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer slideId;
    private String slideImg;
    private String slideLink;
    private String slideTitle;
    private Integer slideStatus;

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
