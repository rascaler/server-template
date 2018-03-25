package com.sky.movie.web.controller;

import com.github.pagehelper.PageInfo;
import com.sky.commons.utils.bean.PageParams;
import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.movie.infrastructure.pojo.dto.CategoryNode;
import com.sky.movie.infrastructure.pojo.dto.VideoDetailDto;
import com.sky.movie.infrastructure.pojo.dto.VideoDto;
import com.sky.movie.infrastructure.pojo.dto.VideoTabDto;
import com.sky.movie.service.CategoryService;
import com.sky.movie.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @OuterResponseBody
    public VideoDetailDto detail(Integer id) {
        return videoService.getDetail(id);
    }


    @RequestMapping(value = "/pageVideos", method = RequestMethod.GET)
    @OuterResponseBody
    public PageInfo<VideoDto> pageVideos(Integer categoryId,PageParams pageParams) {
        return videoService.pageVideos(categoryId,pageParams);
    }



}
