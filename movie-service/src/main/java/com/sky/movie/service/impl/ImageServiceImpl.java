package com.sky.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.commons.utils.bean.BeanMapper;
import com.sky.commons.utils.bean.PageParams;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.domain.CategoryImage;
import com.sky.movie.infrastructure.domain.Image;
import com.sky.movie.infrastructure.manager.CategoryImageManager;
import com.sky.movie.infrastructure.manager.ImageManager;
import com.sky.movie.infrastructure.pojo.dto.ImageDto;
import com.sky.movie.infrastructure.pojo.dto.ImageInfo;
import com.sky.movie.service.ImageService;
import com.sky.movie.service.StatisticsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageManager imageManager;

    @Autowired
    private CategoryImageManager categoryImageManager;


    @Override
    public PageInfo<ImageDto> pageImages(Integer categoryId, PageParams pageParams) throws ServiceException {
        PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize());
        PageHelper.orderBy("createdDate desc");
        List<Image> list = imageManager.listCategoryImages(categoryId);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(BeanMapper.mapList(list, ImageDto.class));
        return pageInfo;
    }

    @Override
    public void saveImage(ImageInfo imageInfo) throws ServiceException {
        Image image = new Image();
        image.setName(imageInfo.getName());
        image.setUrls(imageInfo.getImageUrls());
    }

    @Override
    public ImageDto getDetail(Integer id) throws ServiceException {
        Image image = imageManager.selectByKey(id);
        if(null == image)
            return null;
        ImageDto detail = BeanMapper.map(image, ImageDto.class);
        // 分割地址
        if(StringUtils.isNotEmpty(detail.getUrls()))
            detail.setImageUrls(detail.getUrls().split(","));
        CategoryImage categoryImageQuery = new CategoryImage();
        categoryImageQuery.setImageId(id);
        CategoryImage categoryImage = categoryImageManager.selectOne(categoryImageQuery);
        if(null == categoryImage)
            return null;
        detail.setCategoryId(categoryImage.getCategoryId());
        return detail;
    }
}