package com.sky.movie.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class VideoTabDto implements Serializable {
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

    private List<VideoTabDto> children;

    private List<VideoDto> rankList;

    private List<VideoDto> recentList;
}