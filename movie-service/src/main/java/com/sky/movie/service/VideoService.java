package com.sky.movie.service;

import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.pojo.dto.MovieInfo;

import java.util.List;

public interface VideoService {
    void addVideos(List<MovieInfo> movies) throws ServiceException;
}