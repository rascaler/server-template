package com.sky.movie.infrastructure.pojo.dto;

import java.io.Serializable;

public class StatisticsDto implements Serializable {
    private Integer id;

    /**
     * 视频id
     */
    private Integer videoId;

    /**
     * 点击量
     */
    private Integer pv;

    /**
     * 访客数
     */
    private Integer uv;

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
     * 获取视频id
     *
     * @return videoId - 视频id
     */
    public Integer getVideoId() {
        return videoId;
    }

    /**
     * 设置视频id
     *
     * @param videoId 视频id
     */
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    /**
     * 获取点击量
     *
     * @return pv - 点击量
     */
    public Integer getPv() {
        return pv;
    }

    /**
     * 设置点击量
     *
     * @param pv 点击量
     */
    public void setPv(Integer pv) {
        this.pv = pv;
    }

    /**
     * 获取访客数
     *
     * @return uv - 访客数
     */
    public Integer getUv() {
        return uv;
    }

    /**
     * 设置访客数
     *
     * @param uv 访客数
     */
    public void setUv(Integer uv) {
        this.uv = uv;
    }
}