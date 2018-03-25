package com.sky.movie.service;

import com.github.pagehelper.PageInfo;
import com.sky.commons.utils.bean.PageParams;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.pojo.dto.MovieInfo;
import com.sky.movie.infrastructure.pojo.dto.VideoDetailDto;
import com.sky.movie.infrastructure.pojo.dto.VideoDto;

import java.util.List;

public interface VideoService {
    void addVideos(List<MovieInfo> movies) throws ServiceException;

    VideoDetailDto getDetail(Integer id) throws ServiceException;

    PageInfo<VideoDto> pageVideos(Integer categoryId, PageParams pageParams);
}