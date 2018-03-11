package com.sky.movie.infrastructure.pojo.dto;

import java.io.Serializable;

public class CategoryVideoDto implements Serializable {
    private Integer id;

    private Integer videoId;

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