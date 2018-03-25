package com.sky.movie.service;

import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.pojo.dto.CategoryDto;
import com.sky.movie.infrastructure.pojo.dto.CategoryNode;
import com.sky.movie.infrastructure.pojo.dto.VideoTabDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();

    List<CategoryNode> getCategoryTree() throws ServiceException;


    List<VideoTabDto> getVedioTabs();

    VideoTabDto getCategoryVideo(Integer categoryId) throws ServiceException;
}