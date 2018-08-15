package com.sky.readygo.web.controller;

import com.sky.commons.utils.constant.BasicCode;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.readygo.infrastructure.pojo.dto.DataSourceDto;
import com.sky.readygo.infrastructure.pojo.dto.DataSourceNodeDto;
import com.sky.readygo.infrastructure.pojo.dto.FieldDto;
import com.sky.readygo.infrastructure.pojo.dto.TableDto;
import com.sky.readygo.service.DataSourceService;
import com.sky.readygo.service.TableService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/dataSource")
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;

    @RequestMapping(value = "/getDataSourceTree", method = RequestMethod.GET)
    @OuterResponseBody
    public DataSourceNodeDto getDataSourceTree(@RequestParam Long id) {
        DataSourceNodeDto dataSourceNodeDto = dataSourceService.getDataSourceTree(id);
        if(null == dataSourceNodeDto)
            throw new ServiceException(BasicCode.FAILED);
        System.out.println(111);
        return dataSourceNodeDto;
    }

    @RequestMapping(value = "/getSimpleAll", method = RequestMethod.GET)
    @OuterResponseBody
    public List<DataSourceDto> getSimpleAll () {
        return dataSourceService.listSimpleAll();
    }




}
