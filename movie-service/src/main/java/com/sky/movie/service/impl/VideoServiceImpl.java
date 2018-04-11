package com.sky.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.commons.utils.bean.BeanMapper;
import com.sky.commons.utils.bean.PageParams;
import com.sky.commons.utils.constant.BasicCode;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.domain.Category;
import com.sky.movie.infrastructure.domain.CategoryVideo;
import com.sky.movie.infrastructure.domain.Download;
import com.sky.movie.infrastructure.domain.Video;
import com.sky.movie.infrastructure.manager.CategoryManager;
import com.sky.movie.infrastructure.manager.CategoryVideoManager;
import com.sky.movie.infrastructure.manager.DownloadManager;
import com.sky.movie.infrastructure.manager.VideoManager;
import com.sky.movie.infrastructure.pojo.dto.*;
import com.sky.movie.service.VideoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private CategoryManager categoryManager;

    @Autowired
    private VideoManager videoManager;

    @Autowired
    private CategoryVideoManager categoryVideoManager;

    @Autowired
    private DownloadManager downloadManager;

    @Override
    public void addVideos(List<MovieInfo> movies) throws ServiceException {
        videoManager.addVideos(movies);
    }

    @Override
    public VideoDetailDto getDetail(Integer id) throws ServiceException {
        Video video = videoManager.selectByKey(id);
        if(null == video)
            return null;
        VideoDetailDto detail = BeanMapper.map(video, VideoDetailDto.class);
        if(StringUtils.isNotEmpty(video.getPlotImgUrl())) {
            detail.setPlotImgUrls(video.getPlotImgUrl().split(","));
        }
        // 查询类别
        CategoryVideo categoryVideoQuery = new CategoryVideo();
        categoryVideoQuery.setVideoId(detail.getId());
        List<CategoryVideo> categoryVideos = categoryVideoManager.selectList(categoryVideoQuery);
        if(null != categoryVideos) {
            Example example = new Example(Category.class);
            example.createCriteria().andIn("id",categoryVideos.stream()
                                                        .map(CategoryVideo::getCategoryId)
                                                        .collect(Collectors.toList()));
            List<CategoryDto> categories = BeanMapper.mapList(categoryManager.selectByExample(example),CategoryDto.class);
            detail.setCategories(categories);
        }
        // 查询下载地址
        Download downloadQuery = new Download();
        downloadQuery.setVideoId(id);
        List<DownloadDto> downloadList = BeanMapper.mapList(downloadManager.selectList(downloadQuery), DownloadDto.class);
        detail.setDownloads(downloadList);
        return detail;
    }

    @Override
    public PageInfo<VideoDto> pageVideos(Integer categoryId, PageParams pageParams) {
        PageHelper.startPage(pageParams.getPageNum(),pageParams.getPageSize());
        List<VideoDto> list = videoManager.listVideosByCategoryId(categoryId);
        return new PageInfo(list);
    }
}