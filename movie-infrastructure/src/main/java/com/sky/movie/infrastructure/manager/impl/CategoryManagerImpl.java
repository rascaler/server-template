package com.sky.movie.infrastructure.manager.impl;

import com.sky.movie.infrastructure.domain.Category;
import com.sky.movie.infrastructure.domain.Video;
import com.sky.movie.infrastructure.manager.CategoryManager;
import com.sky.movie.infrastructure.mapper.CategoryMapper;
import com.sky.movie.infrastructure.pojo.dto.MovieInfo;
import com.sky.movie.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManagerImpl extends DefaultManager<Category> implements CategoryManager {

}