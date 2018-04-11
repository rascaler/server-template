package com.sky.movie.infrastructure.manager.impl;

import com.sky.movie.infrastructure.domain.CategoryImage;
import com.sky.movie.infrastructure.domain.Image;
import com.sky.movie.infrastructure.manager.ImageManager;
import com.sky.movie.infrastructure.mapper.CategoryImageMapper;
import com.sky.movie.infrastructure.mapper.ImageMapper;
import com.sky.movie.infrastructure.pojo.dto.ImageInfo;
import com.sky.movie.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageManagerImpl extends DefaultManager<Image> implements ImageManager {

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private CategoryImageMapper categoryImageMapper;

    @Override
    public List<Image> listCategoryImages(Integer categoryId) {
        return imageMapper.selectCategoryImages(categoryId);
    }

    @Override
    public void saveImage(ImageInfo imageInfo) {
        Image image = new Image();
        image.setName(imageInfo.getName());
        image.setUrls(imageInfo.getImageUrls());
        imageMapper.insertSelective(image);
        CategoryImage categoryImage = new CategoryImage();
        categoryImage.setCategoryId(imageInfo.getCategoryId());
        categoryImage.setImageId(image.getId());
        categoryImageMapper.insertSelective(categoryImage);
    }
}