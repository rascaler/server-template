package com.sky.movie.infrastructure.pojo.dto;

import java.io.Serializable;

public class DownloadDto implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 视频id
     */
    private Integer videoId;

    /**
     * 集数
     */
    private Integer num;

    /**
     * 下载类型，百度网盘、迅雷
     */
    private Integer type;

    /**
     * 下载或者观看地址
     */
    private String url;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
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
     * 获取集数
     *
     * @return num - 集数
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置集数
     *
     * @param num 集数
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取下载类型，百度网盘、迅雷
     *
     * @return type - 下载类型，百度网盘、迅雷
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置下载类型，百度网盘、迅雷
     *
     * @param type 下载类型，百度网盘、迅雷
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取下载或者观看地址
     *
     * @return url - 下载或者观看地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置下载或者观看地址
     *
     * @param url 下载或者观看地址
     */
    public void setUrl(String url) {
        this.url = url;
    }
}