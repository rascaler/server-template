package com.sky.readygo.service.impl;

import com.sky.commons.utils.bean.BeanMapper;
import com.sky.commons.utils.constant.BasicCode;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.readygo.infrastructure.domain.DataSource;
import com.sky.readygo.infrastructure.manager.DataSourceManager;
import com.sky.readygo.infrastructure.manager.TableManager;
import com.sky.readygo.infrastructure.manager.impl.JdbcTemplateFactory;
import com.sky.readygo.infrastructure.pojo.dto.DataSourceDto;
import com.sky.readygo.infrastructure.pojo.dto.DataSourceNodeDto;
import com.sky.readygo.infrastructure.pojo.dto.TableDto;
import com.sky.readygo.service.DataSourceService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataSourceServiceImpl implements DataSourceService {

    private Logger logger = LoggerFactory.getLogger(DataSourceServiceImpl.class);

    @Autowired
    private DataSourceManager dataSourceManager;

    @Autowired
    private JdbcTemplateFactory jdbcTemplateFactory;

    @Autowired
    private TableManager tableManager;

    @Override
    public DataSourceNodeDto getDataSourceTree(Long id) {
        DataSource dataSource = dataSourceManager.selectByKey(id);
        if(null == dataSource)
            throw new ServiceException(BasicCode.FAILED);
        // 根节点
        DataSourceNodeDto root = new DataSourceNodeDto();
        root.setId(id);
        root.setDataSourceId(id);
        root.setName(dataSource.getName());
        root.setType(DataSourceNodeDto.DATA_SOURCE);
        root.setLabel(dataSource.getName());
        root.setUid(root.getId().toString());
        // 数据库节点
        String schemaName = getSchema(dataSource);
        if(StringUtils.isEmpty(schemaName))
            return root;
        DataSourceNodeDto schema = new DataSourceNodeDto();
        schema.setName(schemaName);
        schema.setDataSourceId(id);
        schema.setType(DataSourceNodeDto.SCHEMA);
        schema.setLabel(schemaName);
        schema.setUid(id + "_" + schemaName); // dataSourceId + schema
        List<DataSourceNodeDto> schemas = new ArrayList<>();
        schemas.add(schema);
        root.setChildren(schemas);
        // 表格节点
        List<TableDto> tables = tableManager.listTables(id, schemaName);
        if(null == tables || tables.size() == 0)
            return root;
        List<DataSourceNodeDto> tableNodes = new ArrayList<>();
        tables.forEach(t -> {
            DataSourceNodeDto dataSourceNodeDto = new DataSourceNodeDto();
            dataSourceNodeDto.setDataSourceId(id);
            dataSourceNodeDto.setName(t.getName());
            dataSourceNodeDto.setSchemaName(schemaName);
            dataSourceNodeDto.setLabel(t.getName());
            dataSourceNodeDto.setUid(id + "_" + schemaName + "_" + t.getName()); // data_source_schema_table
            dataSourceNodeDto.setType(DataSourceNodeDto.TABLE);
            tableNodes.add(dataSourceNodeDto);
        });
        schema.setChildren(tableNodes);
        return root;
    }

    @Override
    public List<DataSourceDto> listSimpleAll() {
        Example example = new Example(DataSource.class);
        example.selectProperties("id","name","type");
        return BeanMapper.mapList(dataSourceManager.selectByExample(example), DataSourceDto.class);
    }

    // todo
    private  String getSchema (DataSource dataSource) {
        return "rbac";
    }



}