package com.sky.readygo.service.impl;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.sky.commons.utils.bean.BeanMapper;
import com.sky.readygo.infrastructure.pojo.dto.FieldDto;
import com.sky.readygo.infrastructure.pojo.dto.TableDto;
import com.sky.readygo.infrastructure.pojo.dto.TableInfoDto;
import com.sky.readygo.service.TableService;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TableServiceImpl implements TableService {

    private Logger logger = LoggerFactory.getLogger(TableServiceImpl.class);

    @Override
    public List<FieldDto> getTableFields(String schema, String table) {
        try {
            JdbcTemplate jdbcTemplate =  getJdbcTemplate();
            String sql = String.format("select * from information_schema.columns where table_name='%s' and table_schema='%s'", table, schema);
            List<Map<String,Object>> fields = jdbcTemplate.queryForList(sql);
            if(null != fields && fields.size() > 0){
                List<FieldDto> fieldDtos = new ArrayList<>();
                fields.forEach(f -> {
                    FieldDto fieldDto = new FieldDto();
                    fieldDto.setTableName(f.get("TABLE_NAME").toString());
                    fieldDto.setName(f.get("COLUMN_NAME").toString());
                    // 判断类型，获取长度
                    String dataType = f.get("COLUMN_TYPE").toString();
                    Pattern pattern = Pattern.compile("(?<=\\()\\d*(?=\\))");
                    Matcher m = pattern.matcher(dataType);
                    if(m.find())
                        fieldDto.setLength(Integer.parseInt(m.group(0)));
                    fieldDto.setDataType(f.get("DATA_TYPE").toString());
                    Object comment = f.get("COLUMN_COMMENT");
                    fieldDto.setComment(null != comment? comment.toString() : null);
                    fieldDto.setIsNullable(false);
                    Object fieldDefault = f.get("COLUMN_DEFAULT");
                    fieldDto.setFieldDefault(null != fieldDefault? fieldDefault.toString() : null);
                    fieldDtos.add(fieldDto);
                });
                return fieldDtos;
            }
        }catch (Exception e) {
            logger.error("表结构查询失败",e);
        }
        return null;
    }


    @Override
    public List<TableDto> getTables() {
//        try {
//            JdbcTemplate jdbcTemplate = getJdbcTemplate();
//            List<Map<String,Object>> tableList = jdbcTemplate.queryForList("select * from information_schema.tables where table_schema='rbac'");
//            if(null != tableList && tableList.size() > 0) {
//                List<TableDto> result = new ArrayList<>();
//                tableList.forEach(t -> {
//                    TableDto table = new TableDto();
//                    table.setName(t.get("TABLE_NAME").toString());
//                    table.setSchema(t.get("TABLE_SCHEMA").toString());
//                    result.add(table);
//                });
//                return result;
//            }
//        }catch (Exception e) {
//            logger.error("获取表列表失败", e);
//        }
        return null;
    }

    @Override
    public Workbook getTableDoc() {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = xssfWorkbook.createSheet("表格");
        // 创建行头数据
        List<String> header = new ArrayList<String>();
        header.add("字段名");
        header.add("类型");
        header.add("长度");
        header.add("注释");
        List<Map> list = getParams1();
        int rowNum = 0;
        XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        for(int tableIndex = 0; tableIndex < list.size(); tableIndex++) {
            // 添加表名
            Map table = list.get(tableIndex);
            XSSFCell cell = sheet.createRow(rowNum).createCell(0);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(table.get("name").toString());
            sheet.addMergedRegion(new CellRangeAddress(rowNum,rowNum, 0, 3));
            rowNum++;
            // 获取filed
            List<Map> fields = (List<Map>)list.get(0).get("fields");
            XSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(header.get(0));
            row.createCell(1).setCellValue(header.get(1));
            row.createCell(2).setCellValue(header.get(2));
            row.createCell(3).setCellValue(header.get(3));
            rowNum++;
            for(int rowIndex = 0; rowIndex < fields.size();rowIndex ++){
                Map field = fields.get(rowIndex);
                row = sheet.createRow(rowNum);
                row.createCell(0).setCellValue(field.get("column_name").toString());
                row.createCell(1).setCellValue(field.get("column_type").toString());
                row.createCell(2).setCellValue(field.get("column_length").toString());
                row.createCell(3).setCellValue(field.get("column_comment").toString());
                rowNum++;
            }
            sheet.createRow(rowNum);
            rowNum++;
        }
        return xssfWorkbook;
    }

    private List<Map> getParams1() {
        Map<String,Object> params = new HashMap<String,Object>();
        List<Map> tableList = new ArrayList<>();
        Map<String,Object> table = new HashMap<>();
        // tb_app
        // tb_app -- name
        table.put("name","tb_app");
        // tb_app -- fileds
        List<Map<String,Object>> fields = new ArrayList<>();
        Map<String, Object> field = new HashMap<String, Object>();
        field.put("column_name", "id");
        field.put("column_type","Integer");
        field.put("column_length",11);
        field.put("column_comment","测试id");
        fields.add(field);
        field = new HashMap<String, Object>();
        field.put("column_name", "name");
        field.put("column_type","varchar");
        field.put("column_length",11);
        field.put("column_comment","测试name");
        fields.add(field);
        table.put("fields", fields);

        tableList.add(table);

        //tb_user
        table = new HashMap<>();
        table.put("name","tb_user");
        // tb_user -- fileds
        fields = new ArrayList<>();
        field = new HashMap<String, Object>();
        field.put("column_name", "user_id");
        field.put("column_type","Integer");
        field.put("column_length",11);
        field.put("column_comment","测试user_id");
        fields.add(field);
        field = new HashMap<String, Object>();
        field.put("column_name", "user_name");
        field.put("column_type","varchar");
        field.put("column_length",11);
        field.put("column_comment","测试user_name");
        fields.add(field);
        table.put("fields", fields);

        tableList.add(table);
//        params.put("tableList", tableList);

//        return params;
        return tableList;
    }



    private JdbcTemplate getJdbcTemplate() throws Exception{
        DruidDataSource dataSource = getMysqlDataSource();
        // 查询
//        DruidPooledConnection connection =  dataSource.getConnection();
        return new JdbcTemplate(dataSource);
    }


    public DruidDataSource getMysqlDataSource() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        // 设置druid日志
        final Slf4jLogFilter filter = new Slf4jLogFilter();
        filter.setConnectionLogEnabled(false);
        filter.setStatementLogEnabled(true);
        filter.setResultSetLogEnabled(true);
        filter.setStatementExecutableSqlLogEnable(true);
        dataSource.setProxyFilters(new ArrayList<Filter>(){{add(filter);}});
        //设置连接
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/rbac?allowMultiQueries=true&tinyInt1isBit=false&zeroDateTimeBehavior=convertToNull&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setValidationQuery("select 1");
        dataSource.init();
        return dataSource;
    }


}