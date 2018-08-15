package com.sky.readygo.web.controller;

import com.sky.commons.utils.constant.BasicCode;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.readygo.infrastructure.pojo.dto.DataSourceDto;
import com.sky.readygo.infrastructure.pojo.dto.DataSourceNodeDto;
import com.sky.readygo.infrastructure.pojo.dto.GeneratorConfigDto;
import com.sky.readygo.service.DataSourceService;
import com.sky.readygo.service.GeneratorConfigService;
import com.sky.readygo.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/generator")
public class GeneratorController {

    @Autowired
    private GeneratorConfigService generatorConfigService;

    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @OuterResponseBody
    public void saveConfig (GeneratorConfigDto generatorConfigDto) {
        generatorConfigService.save(generatorConfigDto);
    }

    @RequestMapping(value = "/getConfig", method = RequestMethod.POST)
    @OuterResponseBody
    public GeneratorConfigDto getConfig (@RequestParam Long id) {
        return generatorConfigService.getById(id);
    }






}
