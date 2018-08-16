package com.sky.stock.infrastructure.domain.mongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Document(collection="test")
public class TestMongo implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String[] lesson;
    private BigDecimal money;
}
