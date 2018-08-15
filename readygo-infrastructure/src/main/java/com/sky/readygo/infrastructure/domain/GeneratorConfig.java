package com.sky.readygo.infrastructure.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "tb_generator_config")
public class GeneratorConfig {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 数据源id
     */
    @Column(name = "dataSourceId")
    private Long dataSourceId;

    /**
     * 生成器名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 数据库名
     */
    @Column(name = "schemaName")
    private String schemaName;

    /**
     * 表名
     */
    @Column(name = "tableName")
    private String tableName;

    /**
     * 字段名
     */
    @Column(name = "columnName")
    private String columnName;

    /**
     * 生成器配置json
     */
    @Column(name = "config")
    private String config;

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