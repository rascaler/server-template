package com.sky.readygo.service;

import com.sky.readygo.infrastructure.pojo.dto.FieldDto;
import com.sky.readygo.infrastructure.pojo.dto.TableDto;
import com.sky.readygo.infrastructure.pojo.dto.TableInfoDto;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public interface TableService {
    List<FieldDto> getTableFields(String schema, String table);

    List<TableDto> getTables();

    Workbook getTableDoc();
}