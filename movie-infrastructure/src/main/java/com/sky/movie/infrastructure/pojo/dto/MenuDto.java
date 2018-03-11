package com.sky.movie.infrastructure.pojo.dto;

import java.io.Serializable;
import java.util.Date;

public class MenuDto implements Serializable {
    /**
     * 菜单id
     */
    private Integer id;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 菜单链接
     */
    private String url;

    /**
     * 序号
     */
    private Integer queue;

    /**
     * 上级菜单id
     */
    private Integer parentId;

    private Date createdDate;

    private Date updatedDate;

    /**
     * 获取菜单id
     *
     * @return id - 菜单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜单id
     *
     * @param id 菜单id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单名
     *
     * @return name - 菜单名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名
     *
     * @param name 菜单名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取菜单链接
     *
     * @return url - 菜单链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单链接
     *
     * @param url 菜单链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取序号
     *
     * @return queue - 序号
     */
    public Integer getQueue() {
        return queue;
    }

    /**
     * 设置序号
     *
     * @param queue 序号
     */
    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    /**
     * 获取上级菜单id
     *
     * @return parentId - 上级菜单id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级菜单id
     *
     * @param parentId 上级菜单id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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