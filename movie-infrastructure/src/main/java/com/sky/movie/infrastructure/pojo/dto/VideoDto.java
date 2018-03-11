package com.sky.movie.infrastructure.pojo.dto;

import java.io.Serializable;
import java.util.Date;

public class VideoDto implements Serializable {
    private Integer id;

    /**
     * 电影名
     */
    private String name;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 修改时间
     */
    private Date updatedDate;

    /**
     * 演员,多个用逗号隔开
     */
    private String actors;

    /**
     * 发布时间
     */
    private Date publishDate;

    private String directors;

    /**
     * 语言类型
     */
    private String lang;

    /**
     * 影片简介
     */
    private String plot;

    /**
     * 备注
     */
    private String remark;

    /**
     * 剧情图片地址
     */
    private String plotImgUrl;

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
     * 获取电影名
     *
     * @return name - 电影名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置电影名
     *
     * @param name 电影名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图片地址
     *
     * @return imgUrl - 图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imgUrl 图片地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取创建时间
     *
     * @return createdDate - 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置创建时间
     *
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取修改时间
     *
     * @return updatedDate - 修改时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置修改时间
     *
     * @param updatedDate 修改时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * 获取演员,多个用逗号隔开
     *
     * @return actors - 演员,多个用逗号隔开
     */
    public String getActors() {
        return actors;
    }

    /**
     * 设置演员,多个用逗号隔开
     *
     * @param actors 演员,多个用逗号隔开
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * 获取发布时间
     *
     * @return publishDate - 发布时间
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 设置发布时间
     *
     * @param publishDate 发布时间
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * @return directors
     */
    public String getDirectors() {
        return directors;
    }

    /**
     * @param directors
     */
    public void setDirectors(String directors) {
        this.directors = directors;
    }

    /**
     * 获取语言类型
     *
     * @return lang - 语言类型
     */
    public String getLang() {
        return lang;
    }

    /**
     * 设置语言类型
     *
     * @param lang 语言类型
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * 获取影片简介
     *
     * @return plot - 影片简介
     */
    public String getPlot() {
        return plot;
    }

    /**
     * 设置影片简介
     *
     * @param plot 影片简介
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取剧情图片地址
     *
     * @return plotImgUrl - 剧情图片地址
     */
    public String getPlotImgUrl() {
        return plotImgUrl;
    }

    /**
     * 设置剧情图片地址
     *
     * @param plotImgUrl 剧情图片地址
     */
    public void setPlotImgUrl(String plotImgUrl) {
        this.plotImgUrl = plotImgUrl;
    }
}