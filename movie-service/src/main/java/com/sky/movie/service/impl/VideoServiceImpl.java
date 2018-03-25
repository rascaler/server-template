package com.sky.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.commons.utils.bean.BeanMapper;
import com.sky.commons.utils.bean.PageParams;
import com.sky.commons.utils.constant.BasicCode;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.domain.Category;
import com.sky.movie.infrastructure.domain.CategoryVideo;
import com.sky.movie.infrastructure.domain.Video;
import com.sky.movie.infrastructure.manager.CategoryManager;
import com.sky.movie.infrastructure.manager.CategoryVideoManager;
import com.sky.movie.infrastructure.manager.VideoManager;
import com.sky.movie.infrastructure.pojo.dto.CategoryDto;
import com.sky.movie.infrastructure.pojo.dto.MovieInfo;
import com.sky.movie.infrastructure.pojo.dto.VideoDetailDto;
import com.sky.movie.infrastructure.pojo.dto.VideoDto;
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
        return detail;
    }

    @Override
    public PageInfo<VideoDto> pageVideos(Integer categoryId, PageParams pageParams) {
        PageHelper.startPage(pageParams.getPageNum(),pageParams.getPageSize());
        List<Video> list = videoManager.listVideosByCategoryId(categoryId);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(BeanMapper.mapList(list, VideoDto.class));
        return pageInfo;
    }
}