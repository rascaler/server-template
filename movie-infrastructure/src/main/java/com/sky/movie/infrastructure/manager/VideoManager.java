package com.sky.movie.infrastructure.manager;

import com.github.pagehelper.PageInfo;
import com.sky.movie.infrastructure.domain.Video;
import com.sky.movie.infrastructure.pojo.dto.MovieInfo;
import com.sky.movie.infrastructure.pojo.dto.VideoDto;
import com.sky.movie.infrastructure.utils.BaseManager;

import java.util.List;

public interface VideoManager extends BaseManager<Video> {
    int addVideos(List<MovieInfo> movies);

    List<Video> listRecentVideos(Integer categoryId);

    List<Video> listVideosByCategoryId(Integer categoryId);
}