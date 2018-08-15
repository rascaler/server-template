package com.sky.readygo.web.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.sky.commons.web.annotation.OuterResponseBody;
import com.sky.readygo.infrastructure.pojo.dto.FieldDto;
import com.sky.readygo.infrastructure.pojo.dto.TableDto;
import com.sky.readygo.infrastructure.pojo.dto.TableInfoDto;
import com.sky.readygo.service.TableService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/getTableFields", method = RequestMethod.GET)
    @OuterResponseBody
    List<FieldDto> getTableFields(String schema, String table) {
        return tableService.getTableFields(schema, table);
    }

    @RequestMapping(value = "/getTables", method = RequestMethod.GET)
    @OuterResponseBody
    List<TableDto> getTables() {
        return tableService.getTables();
    }

    @RequestMapping(value = "/exportTableDoc", method = RequestMethod.GET)
    void getTableDoc(String schema, String tables,HttpServletRequest request, HttpServletResponse response) throws Exception {
        String codedFileName = "临时文件";
        Workbook workbook =  tableService.getTableDoc();

        if (workbook instanceof HSSFWorkbook) {
            codedFileName = codedFileName + ".xls";
        } else {
            codedFileName = codedFileName + ".xlsx";
        }

        if (isIE(request)) {
            codedFileName = URLEncoder.encode(codedFileName, "UTF8");
        } else {
            codedFileName = new String(codedFileName.getBytes("UTF-8"), "ISO-8859-1");
        }

        response.setHeader("content-disposition", "attachment;filename=" + codedFileName);
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
    }

    protected static boolean isIE(HttpServletRequest request) {
        return request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0 || request.getHeader("USER-AGENT").toLowerCase().indexOf("rv:11.0") > 0 || request.getHeader("USER-AGENT").toLowerCase().indexOf("edge") > 0;
    }

}
