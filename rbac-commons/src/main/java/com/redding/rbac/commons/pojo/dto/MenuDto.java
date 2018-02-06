package com.sky.rbac.commons.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class MenuDto implements Serializable {
    private Integer id;

    private Date createdDate;

    private Date updatedDate;

    private Integer enterpriseId;

    private Integer sequence;

    private Integer appId;

    private String url;

    private String name;

    private Integer type;

    private Integer parentId;

    private String description;

    private String code;

    private Integer level;
}