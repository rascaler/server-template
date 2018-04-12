package com.sky.readygo.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rascaler on 4/11/18.
 */
public class TableExportTest {

    @Test
    public void testExportExcel() throws Exception{
        TemplateExportParams params = new TemplateExportParams(
                "excel/tableTemplate.xlsx", true);
//        params.setColForEach(true);
        Workbook book = ExcelExportUtil.exportExcel(params, getParams());
        //PoiMergeCellUtil.mergeCells(book.getSheetAt(0), 1, 0,1);
        FileOutputStream fos = new FileOutputStream("tmp/tableTemplate1.xlsx");
        book.write(fos);
        fos.close();
    }

    @Test
    public void testExportWord() {

    }


    @Test
    public void testExportTable() throws Exception{
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

        FileOutputStream out = new FileOutputStream("tmp/数据表格.xlsx");
        xssfWorkbook.write(out);
        out.close();
    }


    private Map getParams() {
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
        field.put("column_nam", "name");
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
        field.put("column_name1", "user_id");
        field.put("column_type1","Integer");
        field.put("column_comment1","测试user_id");
        fields.add(field);
        field = new HashMap<String, Object>();
        field.put("column_name1", "user_name");
        field.put("column_type1","varchar");
        field.put("column_comment1","测试user_name");
        fields.add(field);
        table.put("fields", fields);

        tableList.add(table);
        params.put("tableList", tableList);

        return params;
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




    @Test
    public void export() throws Exception{
        //声明一个工作簿
        HSSFWorkbook hwb = new HSSFWorkbook();
        //声明一个单子并命名
        HSSFSheet sheet = hwb.createSheet("设备故障");
        //给单子名称一个长度
        sheet.setDefaultColumnWidth((short)15);
        //生成一个样式
        HSSFCellStyle style = hwb.createCellStyle();
        //创建第一行（也可以成为表头）
        HSSFRow row = sheet.createRow(0);
        //样式字体居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //给表头第一行一次创建单元格
        HSSFCell cell = row.createCell((short) 0);

        cell.setCellValue("用户编号");
        cell.setCellStyle(style);
        cell = row.createCell((short)1);
        cell.setCellValue("余额");
        cell.setCellStyle(style);

        //添加数据
        List<UserWallet> list = new ArrayList<UserWallet>();
        /*list.add(new UserWallet(45,5.20f));
        list.add(new UserWallet(78,8.88f));
        list.add(new UserWallet(106,2.88f));*/

        //向单元格里添加数据
        for(short i=0;i<list.size();i++){
            row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(list.get(i).getUid());
            row.createCell(1).setCellValue(list.get(i).getMoney());
        }

        FileOutputStream out = new FileOutputStream("tmp/学生.xls");
        hwb.write(out);
        out.close();
    }








    class UserWallet implements java.io.Serializable {

        // Fields

        private Integer uid;
        private Float money;

        // Constructors

        /** default constructor */
        public UserWallet() {
        }

        /**
         *
         * <p>Description:这里是自己手动添加的！ </p>
         * 不能自己修改一下构造函数
         * @param uid
         * @param money
         *//*
    public UserWallet(Integer uid, Float money) {
        super();
        this.uid = uid;
        this.money = money;
    }*/

        /** full constructor */
        public UserWallet(Float money) {
            this.money = money;
        }

        // Property accessors

        public Integer getUid() {
            return this.uid;
        }

        public void setUid(Integer uid) {
            this.uid = uid;
        }

        public Float getMoney() {
            return this.money;
        }

        public void setMoney(Float money) {
            this.money = money;
        }

    }
}
