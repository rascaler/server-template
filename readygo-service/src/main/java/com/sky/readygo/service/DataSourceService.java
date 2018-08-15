package com.sky.readygo.service;

import com.sky.readygo.infrastructure.pojo.dto.DataSourceDto;
import com.sky.readygo.infrastructure.pojo.dto.DataSourceNodeDto;
import com.sky.readygo.infrastructure.pojo.dto.FieldDto;
import com.sky.readygo.infrastructure.pojo.dto.TableDto;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface DataSourceService {

    DataSourceNodeDto getDataSourceTree (Long id);

    List<DataSourceDto> listSimpleAll();
}