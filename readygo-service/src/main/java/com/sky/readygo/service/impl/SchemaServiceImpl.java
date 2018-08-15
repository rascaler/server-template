package com.sky.readygo.service.impl;

import com.sky.commons.utils.bean.BeanMapper;
import com.sky.readygo.infrastructure.domain.Schema;
import com.sky.readygo.infrastructure.manager.SchemaManager;
import com.sky.readygo.infrastructure.pojo.dto.SchemaDto;
import com.sky.readygo.infrastructure.pojo.dto.SchemaInfoDto;
import com.sky.readygo.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemaServiceImpl implements SchemaService {

    @Autowired
    private SchemaManager schemaManager;

    @Override
    public void save(SchemaInfoDto schemaInfoDto) {
        Schema schema = BeanMapper.map(schemaInfoDto, Schema.class);
        schemaManager.insertSelective(schema);
    }
}