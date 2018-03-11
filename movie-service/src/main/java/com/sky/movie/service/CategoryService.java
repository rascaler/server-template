package com.sky.movie.service;

import com.sky.movie.infrastructure.pojo.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
}