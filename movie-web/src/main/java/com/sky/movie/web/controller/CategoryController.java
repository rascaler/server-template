package com.sky.movie.web.controller;

import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.movie.infrastructure.pojo.dto.CategoryDto;
import com.sky.movie.infrastructure.pojo.dto.CategoryNode;
import com.sky.movie.infrastructure.pojo.dto.VideoTabDto;
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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/getCategoryTree", method = RequestMethod.GET)
    @OuterResponseBody
    public List<CategoryNode> getCategoryTree() {
        return categoryService.getCategoryTree();
    }


    @RequestMapping(value = "/getVedioTabs", method = RequestMethod.GET)
    @OuterResponseBody
    public List<VideoTabDto> getVedioTabs() {
        return categoryService.getVedioTabs();
    }

    @RequestMapping(value = "/getCategoryVideo", method = RequestMethod.GET)
    @OuterResponseBody
    public VideoTabDto getCategoryVideo(Integer id) {
        return categoryService.getCategoryVideo(id);
    }


}
