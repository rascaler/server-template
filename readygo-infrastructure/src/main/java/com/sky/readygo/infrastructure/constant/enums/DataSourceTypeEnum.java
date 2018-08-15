package com.sky.readygo.infrastructure.constant.enums;

public enum DataSourceTypeEnum {

    MYSQL("MYSQL",1), ORACLE("ORACLE", 2);

    private Integer value;
    private String name;

    private  DataSourceTypeEnum (String name, Integer value) {
        this.value = value;
        this.name = name;
    }

}
