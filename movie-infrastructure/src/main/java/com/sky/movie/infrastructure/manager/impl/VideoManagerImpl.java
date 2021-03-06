package com.sky.movie.infrastructure.manager.impl;

import com.sky.commons.utils.constant.BasicCode;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.movie.infrastructure.domain.*;
import com.sky.movie.infrastructure.manager.VideoManager;
import com.sky.movie.infrastructure.mapper.*;
import com.sky.movie.infrastructure.pojo.dto.MovieInfo;
import com.sky.movie.infrastructure.pojo.dto.VideoDto;
import com.sky.movie.infrastructure.utils.DefaultManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideoManagerImpl extends DefaultManager<Video> implements VideoManager {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CategoryVideoMapper categoryVideoMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DownloadMapper downloadMapper;

    @Autowired
    private StatisticsMapper statisticsMapper;

    @Override
    public int addVideos(List<MovieInfo> movieInfos) {
        List<Category> list = categoryMapper.selectAll();
        for(MovieInfo movieInfo: movieInfos) {
            // 查询影片是否已经存在
            Video query = new Video();
            query.setName(movieInfo.getName());
            List<Video> result = videoMapper.select(query);
            if(null != result && result.size() > 0) continue;
            Video video = new Video();
            video.setName(movieInfo.getName());
            video.setImgUrl(movieInfo.getImgUrl());
            // 设置类别
            String plotImgs = "";
            if(null != movieInfo.getPlots()) {
                for(String url:movieInfo.getPlots()) {
                    if(StringUtils.isEmpty(plotImgs)) plotImgs = url;
                    else plotImgs+=("," + url);
                }
            }
            video.setPlotImgUrl(plotImgs);

            //插入movie信息
            videoMapper.insertSelective(video);
            //关联类别
            CategoryVideo categoryVideo = new CategoryVideo();
            categoryVideo.setVideoId(video.getId());
            Optional<Category> optional = list.stream().filter(l -> l.getName().equals(movieInfo.getType())).findFirst();
            if(!optional.isPresent()) throw new RuntimeException("失败");
            categoryVideo.setCategoryId(optional.get().getId());
            categoryVideoMapper.insertSelective(categoryVideo);

            //下载地址
            List<Download> downloads = new ArrayList<>();
            if(null != movieInfo.getDownloadUrls()) {
                for(String downloadUrl : movieInfo.getDownloadUrls()) {
                    Download download = new Download();
                    download.setVideoId(video.getId());
                    download.setType(getType(downloadUrl));
                    download.setUrl(downloadUrl);
                    download.setNum(1);
                    downloads.add(download);
                }
                downloadMapper.insertList(downloads);
            }
            // 写入pv,uv
            Statistics statistics = new Statistics();
            statistics.setVideoId(video.getId());
            statisticsMapper.insertSelective(statistics);
        }
        return 1;
    }

    @Override
    public List<Video> listRecentVideos(Integer categoryId) {
        return videoMapper.selectRecentVideos(categoryId);
    }

    @Override
    public List<VideoDto> listVideosByCategoryId(Integer categoryId) {
        return videoMapper.selectVideosByCategoryId(categoryId);
    }

    public Integer getType(String type) {
        if(type.startsWith("thunder")) return 1;// 迅雷
        if(type.startsWith("qqdl")) return 2; //旋风
        if(type.startsWith("flashget")) return 3; //快车
        if(type.startsWith("ed2k")) return 4; //电驴
        return null;
    }

}