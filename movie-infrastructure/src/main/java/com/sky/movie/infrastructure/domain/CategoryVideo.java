package com.sky.movie.infrastructure.domain;

import javax.persistence.*;

@Table(name = "tb_category_video")
public class CategoryVideo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "videoId")
    private Integer videoId;

    @Column(name = "categoryId")
    private Integer categoryId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return videoId
     */
    public Integer getVideoId() {
        return videoId;
    }

    /**
     * @param videoId
     */
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    /**
     * @return categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}