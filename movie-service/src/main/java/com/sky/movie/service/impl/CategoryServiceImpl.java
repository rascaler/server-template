package com.sky.movie.service.impl;


import com.sky.commons.utils.bean.BeanMapper;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.domain.Category;
import com.sky.movie.infrastructure.domain.Video;
import com.sky.movie.infrastructure.manager.CategoryManager;
import com.sky.movie.infrastructure.manager.VideoManager;
import com.sky.movie.infrastructure.pojo.dto.CategoryDto;
import com.sky.movie.infrastructure.pojo.dto.CategoryNode;
import com.sky.movie.infrastructure.pojo.dto.VideoDto;
import com.sky.movie.infrastructure.pojo.dto.VideoTabDto;
import com.sky.movie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryManager categoryManager;

    @Autowired
    private VideoManager videoManager;

    @Override
    public List<CategoryDto> getAll() {
        return BeanMapper.mapList(categoryManager.selectAll(), CategoryDto.class);
    }

    @Override
    public List<CategoryNode> getCategoryTree() throws ServiceException {
        Category query = new Category();
        query.setParentId(0);
        List<CategoryNode> list = BeanMapper.mapList(categoryManager.selectList(query), CategoryNode.class);
        if(null != list && list.size() > 0) {
            list.forEach(l -> {
                query.setParentId(l.getId());
                l.setChildren(BeanMapper.mapList(categoryManager.selectList(query), CategoryNode.class));
            });
        }
        return list;
    }


    @Override
    public List<VideoTabDto> getVedioTabs() {
        // 查询首页需要展示的类别
        Category query = new Category();
        query.setShowTab(1);
        List<VideoTabDto> videoTabs = BeanMapper.mapList(categoryManager.selectList(query), VideoTabDto.class);
        if(null != videoTabs && videoTabs.size() > 0) {
            videoTabs.forEach(v -> {
                // 查询最新更新 10部
                List<Video> recentList = videoManager.listRecentVideos(v.getId());
                // todo 查询排行榜 显示10条
                v.setRecentList(BeanMapper.mapList(recentList, VideoDto.class));
                v.setRankList(BeanMapper.mapList(recentList, VideoDto.class));
            });
        }
        return videoTabs;
    }

    @Override
    public VideoTabDto getCategoryVideo(Integer categoryId) throws ServiceException {
        VideoTabDto videoTabDto = BeanMapper.map(categoryManager.selectByKey(categoryId), VideoTabDto.class);
        if(null == videoTabDto)
            return null;
        // 获取最近更新
        List<Video> recentList = videoManager.listRecentVideos(categoryId);
        videoTabDto.setRecentList(BeanMapper.mapList(recentList, VideoDto.class));
        return videoTabDto;
    }
}