package com.sky.readygo.web.controller;

import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.readygo.infrastructure.pojo.dto.SchemaDto;
import com.sky.readygo.infrastructure.pojo.dto.SchemaInfoDto;
import com.sky.readygo.service.SchemaService;
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
@RequestMapping("/schema")
public class SchemaController {

    @Autowired
    private SchemaService schemaService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @OuterResponseBody
    void save(SchemaInfoDto schemaInfoDto) {
        schemaService.save(schemaInfoDto);
    }



}
