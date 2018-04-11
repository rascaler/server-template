package com.sky.movie.infrastructure.manager;

import com.sky.movie.infrastructure.domain.Image;
import com.sky.movie.infrastructure.pojo.dto.ImageInfo;
import com.sky.movie.infrastructure.utils.BaseManager;

import java.util.List;

public interface ImageManager extends BaseManager<Image> {
    List<Image> listCategoryImages(Integer categoryId);

    void saveImage(ImageInfo imageInfo);
}