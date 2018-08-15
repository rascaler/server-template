package com.sky.readygo.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataSourceNodeDto {

    public static final int  DATA_SOURCE= 0;

    public static final int  SCHEMA= 1;

    public static final int  TABLE= 2;

    private Long id;

    private Long dataSourceId;

    private String name;

    private Integer type;

    private String schemaName;

    private String label;

    private String uid;

    private List<DataSourceNodeDto> children;
}
