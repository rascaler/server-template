package com.sky.movie.infrastructure.mapper;

import com.sky.movie.infrastructure.domain.Image;
import com.sky.movie.infrastructure.utils.MyMapper;

import java.util.List;

public interface ImageMapper extends MyMapper<Image> {
    List<Image> selectCategoryImages(Integer categoryId);
}