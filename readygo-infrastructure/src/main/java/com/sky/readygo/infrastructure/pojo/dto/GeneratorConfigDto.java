package com.sky.readygo.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GeneratorConfigDto {

    /**
     * id
     */
    private Long id;

    /**
     * 数据源id
     */
    private Long dataSourceId;

    /**
     * 生成器名称
     */
    private String name;

    /**
     * 数据库名
     */
    private String schemaName;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 生成器配置json
     */
    private String config;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 修改时间
     */
    private Date updatedDate;
}