package com.sky.template.web.controller;

import com.sky.template.service.AppDto;
import com.sky.template.service.AppService;
import com.sky.template.web.utils.annotation.OuterResponseBody;
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
    private AppService appService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @OuterResponseBody
    List<AppDto> getAll() {
        return appService.getAll();
    }


    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @OuterResponseBody
    AppDto getOne() {
        return appService.getOne();
    }
}
