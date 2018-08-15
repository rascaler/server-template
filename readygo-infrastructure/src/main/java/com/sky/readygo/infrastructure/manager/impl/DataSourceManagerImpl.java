package com.sky.readygo.infrastructure.manager.impl;

import com.sky.readygo.infrastructure.domain.DataSource;
import com.sky.readygo.infrastructure.manager.DataSourceManager;
import com.sky.readygo.infrastructure.mapper.DataSourceMapper;
import com.sky.readygo.infrastructure.utils.DefaultManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataSourceManagerImpl extends DefaultManager<DataSource> implements DataSourceManager {

    @Autowired
    private JdbcTemplateFactory jdbcTemplateFactory;


}