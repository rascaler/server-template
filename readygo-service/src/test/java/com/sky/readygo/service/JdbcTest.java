package com.sky.readygo.service;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rascaler on 4/11/18.
 */
public class JdbcTest {

    @Test
    public void testMysql() throws Exception{

        DruidDataSource dataSource = getMysqlDataSource();
        // 查询
        DruidPooledConnection connection =  dataSource.getConnection();
        // 获取所有表
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, null, new String[] {"TABLE"});
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("TABLE_NAME"));
        }
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from tb_user");
        while (result.next()){
            System.out.println(result.getObject("name"));
        }
        return;
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


    @Test
    public void testTableInfo() throws Exception {
        DruidDataSource dataSource = getMysqlDataSource();
        // 查询
        DruidPooledConnection connection =  dataSource.getConnection();
//        System.out.print(connection.getSchema());
        // 获取所有表
        DatabaseMetaData metaData = connection.getMetaData();
//        ResultSetExtractor extractor = (ResultSetExtractor)(new RowMapperResultSetExtractor<>(new ColumnMapRowMapper()));
//        List result1 = (List)extractor.extractData(metaData.getSchemas());
        ResultSet schemas = metaData.getSchemas();
        while (schemas.next()) {

        }
//        System.out.println("数据库名称：" + JSON.toJSONString(result1));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        // 获取数据库名
//        String schema = jdbcTemplate.queryForObject("select schema()",String.class);
//        System.out.print("数据库名称" + metaData.getSchemaTerm());

//        SqlRowSet srcSqlRowSet = srcJdbcTemplate.queryForRowSet("SELECT * FROM tablename LIMIT 0"); //注意limit 0更合适
//        SqlRowSetMetaData sqlRowSetMetaData = sqlRowSet.getMetaData();
        String sql = "select * from information_schema.columns where table_name='tb_user' and table_schema='rbac'";
        List result = jdbcTemplate.queryForList(sql);
        System.out.println("数据总数：" + JSON.toJSONString(result));
    }


    @Test
    public void testTableInfo2() throws Exception{
        SqlRowSet rowSet = getJdbcTemplate().queryForRowSet("select * from tb_app limit 0");
        SqlRowSetMetaData metaData = rowSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            Map<String,String> fieldMap = new HashMap<String,String>();
            fieldMap.put("ColumnName", metaData.getColumnName(i));
            fieldMap.put("ColumnType", String.valueOf(metaData.getColumnType(i)));
            fieldMap.put("ColumnTypeName", metaData.getColumnTypeName(i));
            fieldMap.put("CatalogName", metaData.getCatalogName(i));
            fieldMap.put("ColumnClassName", metaData.getColumnClassName(i));
            fieldMap.put("ColumnLabel", metaData.getColumnLabel(i));
            fieldMap.put("Precision", String.valueOf(metaData.getPrecision(i)));
            fieldMap.put("Scale", String.valueOf(metaData.getScale(i)));
            fieldMap.put("SchemaName", metaData.getSchemaName(i));
            fieldMap.put("TableName", metaData.getTableName(i));
            fieldMap.put("SchemaName", metaData.getSchemaName(i));
            System.out.println(JSON.toJSONString(fieldMap));
        }
    }


    @Test
    public void testCatelog() throws Exception{
        DatabaseMetaData dbMetaData = getJdbcTemplate().getDataSource().getConnection().getMetaData();
//        metaData.getCatalogs();
        try {
            System.out.println("数据库已知的用户: "+ dbMetaData.getUserName());
            System.out.println("数据库的系统函数的逗号分隔列表: "+ dbMetaData.getSystemFunctions());
            System.out.println("数据库的时间和日期函数的逗号分隔列表: "+ dbMetaData.getTimeDateFunctions());
            System.out.println("数据库的字符串函数的逗号分隔列表: "+ dbMetaData.getStringFunctions());
            System.out.println("数据库供应商用于 'schema' 的首选术语: "+ dbMetaData.getSchemaTerm());
            System.out.println("数据库URL: " + dbMetaData.getURL());
            System.out.println("是否允许只读:" + dbMetaData.isReadOnly());
            System.out.println("数据库的产品名称:" + dbMetaData.getDatabaseProductName());
            System.out.println("数据库的版本:" + dbMetaData.getDatabaseProductVersion());
            System.out.println("驱动程序的名称:" + dbMetaData.getDriverName());
            System.out.println("驱动程序的版本:" + dbMetaData.getDriverVersion());
            System.out.println("驱动程序的版本:" + dbMetaData.getDriverVersion());


            System.out.println();
//            System.out.println("数据库中使用的表类型");
//            ResultSet rs = dbMetaData.getTableTypes();
//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//            }
//            rs.close();
//            System.out.println();

            ResultSet rs = dbMetaData.getCatalogs();
            while (rs.next()) {
                System.out.print(rs.getObject(1));
            }
            return;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }


    @Test
    public void testMysqlSchema() throws Exception{
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        String schema = jdbcTemplate.queryForObject("select schema()",String.class);
        System.out.print("数据库名称：" + schema);
    }

    private JdbcTemplate getJdbcTemplate() throws Exception{
        DruidDataSource dataSource = getMysqlDataSource();
        // 查询
        DruidPooledConnection connection =  dataSource.getConnection();
        return new JdbcTemplate(dataSource);
    }


}
