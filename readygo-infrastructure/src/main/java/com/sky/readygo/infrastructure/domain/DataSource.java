package com.sky.readygo.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "tb_data_source")
public class DataSource {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 数据源连接字符串
     */
    @Column(name = "url")
    private String url;

    /*
     * 别名
     */
    @Column(name = "name")
    private String name;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;


    /**
     * 数据库类型
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 创建时间
     */
    @Column(name = "createdDate")
    private Date createdDate;

    /**
     * 修改时间
     */
    @Column(name = "updatedDate")
    private Date updatedDate;
}