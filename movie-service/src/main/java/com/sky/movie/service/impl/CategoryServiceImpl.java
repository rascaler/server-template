package com.sky.movie.service.impl;


import com.sky.commons.utils.bean.BeanMapper;
import com.sky.movie.infrastructure.manager.CategoryManager;
import com.sky.movie.infrastructure.pojo.dto.CategoryDto;
import com.sky.movie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryManager categoryManager;

    @Override
    public List<CategoryDto> getAll() {
        return BeanMapper.mapList(categoryManager.selectAll(), CategoryDto.class);
    }
}