package com.sky.movie.web.controller;

import com.github.pagehelper.PageInfo;
import com.sky.commons.utils.bean.PageParams;
import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.movie.infrastructure.pojo.dto.CategoryNode;
import com.sky.movie.infrastructure.pojo.dto.ImageDto;
import com.sky.movie.infrastructure.pojo.dto.VideoTabDto;
import com.sky.movie.service.CategoryService;
import com.sky.movie.service.ImageService;
import com.sky.movie.service.spiders.ImageSpider;
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
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageSpider imageSpider;

    @RequestMapping(value = "/pageCategoryImages", method = RequestMethod.GET)
    @OuterResponseBody
    public PageInfo<ImageDto> pageImages(Integer categoryId, PageParams pageParams) {
        return imageService.pageImages(categoryId, pageParams);
    }


    @RequestMapping(value = "/startImageSpider", method = RequestMethod.GET)
    @OuterResponseBody
    public void startImageSpider(String key) {
        imageSpider.startImageSpider(key);
    }






}
