package com.sky.readygo.infrastructure.manager.impl;

import com.sky.readygo.infrastructure.domain.Schema;
import com.sky.readygo.infrastructure.manager.SchemaManager;
import com.sky.readygo.infrastructure.manager.TableManager;
import com.sky.readygo.infrastructure.mapper.DataSourceMapper;
import com.sky.readygo.infrastructure.pojo.dto.TableDto;
import com.sky.readygo.infrastructure.utils.DefaultManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TableManagerImpl implements TableManager {

    private Logger logger = LoggerFactory.getLogger(TableManagerImpl.class);

    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Autowired
    private JdbcTemplateFactory jdbcTemplateFactory;

    @Override
    public List<TableDto> listTables(Long dataSourceId, String schemaName) {
        try {
            JdbcTemplate jdbcTemplate = jdbcTemplateFactory.getJdbcTemplate(dataSourceId);
            List<Map<String,Object>> tableList = jdbcTemplate.queryForList(String.format("select * from information_schema.tables where table_schema='%s'", schemaName));
            if(null != tableList && tableList.size() > 0) {
                List<TableDto> result = new ArrayList<>();
                tableList.forEach(t -> {
                    TableDto table = new TableDto();
                    table.setName(t.get("TABLE_NAME").toString());
                    table.setSchema(t.get("TABLE_SCHEMA").toString());
                    result.add(table);
                });
                return result;
            }
        }catch (Exception e) {
            logger.error("获取表列表失败", e);
        }
        return null;
    }
}