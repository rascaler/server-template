package com.sky.movie.infrastructure.pojo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by rascaler on 3/21/18.
 */

@Getter
@Setter
public class ImageInfo {
    private String name;
    private String url;
    private String imageUrls;
    private Integer categoryId;
}
