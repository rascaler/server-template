package com.sky.readygo.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class FieldDto implements Serializable {

    private String tableName;

    private String name;

    private Integer length;

    private String dataType;

    private String extra;

    private String comment;

    private Boolean isNullable;

    private String fieldDefault;

}
