package com.sky.readygo.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class DataSourceDto {

    /**
     * id
     */
    private Long id;

    /**
     * 数据源连接字符串
     */
    private String url;

    /*
     * 别名
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


    /**
     * 数据库类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 修改时间
     */
    private Date updatedDate;
}