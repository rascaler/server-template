package com.sky.movie.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class ImageDto implements Serializable {
    private Integer id;

    private String name;

    private Date createdDate;

    private Date updatedDate;

    private String urls;

}