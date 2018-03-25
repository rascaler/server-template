package com.sky.movie.infrastructure.manager.impl;

import com.sky.movie.infrastructure.domain.CategoryImage;
import com.sky.movie.infrastructure.manager.CategoryImageManager;
import com.sky.movie.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class CategoryImageManagerImpl extends DefaultManager<CategoryImage> implements CategoryImageManager {
}