package com.sky.readygo.infrastructure.manager.impl;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.sky.commons.utils.constant.BasicCode;
import com.sky.commons.utils.context.ApplicationContextUtils;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.readygo.infrastructure.domain.DataSource;
import com.sky.readygo.infrastructure.manager.DataSourceManager;
import com.sky.readygo.infrastructure.mapper.DataSourceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class JdbcTemplateFactory {

    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateFactory.class);

    private static Map<Long, JdbcTemplate> caches = new HashMap<>();

    @Autowired
    private DataSourceMapper dataSourceMapper;

    public JdbcTemplate getJdbcTemplate (Long dataSourceId) {
        JdbcTemplate jdbcTemplateCache = caches.get(dataSourceId);
        if(null == jdbcTemplateCache) {
            try {
                synchronized (JdbcTemplateFactory.class) {
                    if(caches.get(dataSourceId) != null)
                        return caches.get(dataSourceId);
                    DataSource dataSource = dataSourceMapper.selectByPrimaryKey(dataSourceId);
                    if(null == dataSource) {
                        logger.error("dataSource不能为空");
                        throw new ServiceException(BasicCode.FAILED);
                    }
                    JdbcTemplate jdbcTemplate = new JdbcTemplate(createDataSource(dataSource));
                    if(null == jdbcTemplate) {
                        logger.error("jdbcTemplate创建失败");
                        throw new ServiceException(BasicCode.FAILED);
                    }
                    // 加入cache
                    caches.put(dataSourceId, jdbcTemplate);
                    return jdbcTemplate;
                }
            }catch (Exception e) {
                logger.error("jdbcTemplate创建失败", e);
                throw new ServiceException(BasicCode.FAILED);
            }
        } else {
            return caches.get(dataSourceId);
        }
    }

    public static DruidDataSource createDataSource(DataSource ds) throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        // 设置druid日志
        final Slf4jLogFilter filter = new Slf4jLogFilter();
        filter.setConnectionLogEnabled(false);
        filter.setStatementLogEnabled(true);
        filter.setResultSetLogEnabled(true);
        filter.setStatementExecutableSqlLogEnable(true);
        dataSource.setProxyFilters(new ArrayList<Filter>(){{add(filter);}});
        //设置连接
        if(ds.getType() == 1) { // mysql
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            // jdbc:mysql://127.0.0.1:3306/rbac?allowMultiQueries=true&tinyInt1isBit=false&zeroDateTimeBehavior=convertToNull&useSSL=false
            dataSource.setUrl(ds.getUrl());
            dataSource.setUsername(ds.getUsername());
            dataSource.setPassword(ds.getPassword());
            // dataSourceConfig
            dataSource.setValidationQuery("select 1");
        }
        dataSource.init();
        return dataSource;
    }

}
