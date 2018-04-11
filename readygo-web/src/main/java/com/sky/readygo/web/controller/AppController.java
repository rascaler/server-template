package com.sky.readygo.web.controller;

import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.readygo.infrastructure.pojo.dto.AppDto;
import com.sky.readygo.service.AppService;
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
