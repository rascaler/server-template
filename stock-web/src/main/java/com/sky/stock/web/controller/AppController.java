package com.sky.stock.web.controller;

import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.stock.infrastructure.domain.mongo.TestMongo;
import com.sky.stock.infrastructure.pojo.dto.AppDto;
import com.sky.stock.infrastructure.repository.TestRepository;
import com.sky.stock.service.AppService;
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

    @Autowired
    private TestRepository testRepository;

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

    @RequestMapping(value = "/testMongo", method = RequestMethod.GET)
    @OuterResponseBody
    List<TestMongo> testMongo() {
        return testRepository.findByName("qing");
    }
}
