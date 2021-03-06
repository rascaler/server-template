package com.sky.movie.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;
@Getter
@Setter
@Table(name = "tb_category")
public class Category {
    /**
     * 类别id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    /**
     * 地址
     */
    @Column(name = "url")
    private String url;

    /**
     * 上级
     */
    @Column(name = "parentId")
    private Integer parentId;

    /**
     * 序列
     */
    @Column(name = "queue")
    private Integer queue;

    @Column(name = "showTab")
    private Integer showTab;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

}