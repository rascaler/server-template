package com.sky.movie.infrastructure.mapper;

import com.sky.movie.infrastructure.domain.Video;
import com.sky.movie.infrastructure.pojo.dto.VideoDto;
import com.sky.movie.infrastructure.utils.MyMapper;

import java.util.List;

public interface VideoMapper extends MyMapper<Video> {
    List<Video> selectRecentVideos(Integer categoryId);

    List<VideoDto> selectVideosByCategoryId(Integer categoryId);
}