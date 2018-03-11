package com.sky.movie.infrastructure.pojo.dto;

import java.io.Serializable;
import java.util.Date;

public class CategoryDto implements Serializable {
    /**
     * 类别id
     */
    private Integer id;

    private String name;

    /**
     * 地址
     */
    private String url;

    /**
     * 上级
     */
    private Integer parentId;

    /**
     * 序列
     */
    private Integer queue;

    private Date createdDate;

    private Date updatedDate;

    /**
     * 获取类别id
     *
     * @return id - 类别id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置类别id
     *
     * @param id 类别id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取地址
     *
     * @return url - 地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置地址
     *
     * @param url 地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取上级
     *
     * @return parentId - 上级
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级
     *
     * @param parentId 上级
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取序列
     *
     * @return queue - 序列
     */
    public Integer getQueue() {
        return queue;
    }

    /**
     * 设置序列
     *
     * @param queue 序列
     */
    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    /**
     * @return createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return updatedDate
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}