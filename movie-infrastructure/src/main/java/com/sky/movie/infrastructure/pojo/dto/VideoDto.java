package com.sky.movie.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
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

    ////////////扩展字段/////////////////////
    private Integer pv;

    private Integer uv;
}