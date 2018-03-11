package com.sky.movie.service.impl;

import com.sky.commons.utils.constant.BasicCode;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.domain.Category;
import com.sky.movie.infrastructure.domain.CategoryVideo;
import com.sky.movie.infrastructure.domain.Video;
import com.sky.movie.infrastructure.manager.CategoryManager;
import com.sky.movie.infrastructure.manager.VideoManager;
import com.sky.movie.infrastructure.pojo.dto.MovieInfo;
import com.sky.movie.service.VideoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private CategoryManager categoryManager;

    @Autowired
    private VideoManager videoManager;

    @Override
    public void addVideos(List<MovieInfo> movies) throws ServiceException {
        videoManager.addVideos(movies);
    }
}