package com.sky.readygo.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class SchemaDto implements Serializable {

      private Integer id;

      private String name;

      private Integer type;

      private List<TableDto> children;

}
