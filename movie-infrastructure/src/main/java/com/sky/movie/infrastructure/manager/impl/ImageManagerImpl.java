package com.sky.movie.infrastructure.manager.impl;

import com.sky.movie.infrastructure.domain.Image;
import com.sky.movie.infrastructure.manager.ImageManager;
import com.sky.movie.infrastructure.mapper.ImageMapper;
import com.sky.movie.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageManagerImpl extends DefaultManager<Image> implements ImageManager {

    @Autowired
    private ImageMapper imageMapper;
    @Override
    public List<Image> listCategoryImages(Integer categoryId) {
        return imageMapper.selectCategoryImages(categoryId);
    }
}