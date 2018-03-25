package com.sky.movie.service;

import com.github.pagehelper.PageInfo;
import com.sky.commons.utils.bean.PageParams;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.pojo.dto.ImageDto;

public interface ImageService {

    PageInfo<ImageDto> pageImages(Integer categoryId, PageParams pageParams) throws ServiceException;
}