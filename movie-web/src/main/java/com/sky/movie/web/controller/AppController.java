package com.sky.movie.web.controller;

import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.movie.infrastructure.pojo.dto.CategoryDto;
import com.sky.movie.service.CategoryService;
import com.sky.movie.service.VideoService;
import com.sky.movie.service.spiders.MovieSpider;
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
@RequestMapping("/app")
public class AppController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private MovieSpider movieSpider;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @OuterResponseBody
    List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @RequestMapping(value = "/startSpider", method = RequestMethod.GET)
    @OuterResponseBody
    void startSpider() {
        // 亚洲情色 504页 1
        // 制服丝袜 80页 2
        // 欧美性爱 98页 3
        // 网友自拍 37页 4
        // 经典三级 34页 5
        // 乱伦虐待 14页 6
        // 乱伦虐待 8页 7
        // 成人动漫 28页 8
        movieSpider.startSpider();
    }
}
