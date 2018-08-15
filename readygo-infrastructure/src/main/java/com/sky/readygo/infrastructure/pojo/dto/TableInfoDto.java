package com.sky.readygo.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class TableInfoDto implements Serializable {


    /**
     * TABLE_CATALOG : def
     * TABLE_SCHEMA : rbac
     * TABLE_NAME : tb_app
     * COLUMN_NAME : code
     * ORDINAL_POSITION : 3
     * COLUMN_DEFAULT : null
     * IS_NULLABLE : YES
     * DATA_TYPE : varchar
     * CHARACTER_MAXIMUM_LENGTH : 64
     * CHARACTER_OCTET_LENGTH : 192
     * NUMERIC_PRECISION : null
     * NUMERIC_SCALE : null
     * DATETIME_PRECISION : null
     * CHARACTER_SET_NAME : utf8
     * COLLATION_NAME : utf8_general_ci
     * COLUMN_TYPE : varchar(64)
     * COLUMN_KEY :
     * EXTRA :
     * PRIVILEGES : select,insert,update,references
     * COLUMN_COMMENT : 应用编码
     */

//    SELECT * FROM information_schema.columns
//    WHERE `table_schema` = 'rbac'
//    AND `table_name` = 'tb_app'


//    private String TABLE_CATALOG;
//    private String TABLE_SCHEMA;
//    private String TABLE_NAME;
//    private String COLUMN_NAME;
//    private Long ORDINAL_POSITION;
//    private String COLUMN_DEFAULT;
//    private String IS_NULLABLE;
//    private String DATA_TYPE;
//    private Long CHARACTER_MAXIMUM_LENGTH;
//    private Long CHARACTER_OCTET_LENGTH;
//    private Long NUMERIC_PRECISION;
//    private Long NUMERIC_SCALE;
//    private Long DATETIME_PRECISION;
//    private String CHARACTER_SET_NAME;
//    private String COLLATION_NAME;
//    private String COLUMN_TYPE;
//    private String COLUMN_KEY;
//    private String EXTRA;
//    private String PRIVILEGES;
//    private String COLUMN_COMMENT;

      private String name;

      private Integer length;

}
