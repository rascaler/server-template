package com.sky.readygo.service.impl;

import com.sky.commons.utils.bean.BeanMapper;
import com.sky.commons.utils.exception.ServiceException;
import com.sky.readygo.infrastructure.domain.GeneratorConfig;
import com.sky.readygo.infrastructure.domain.Schema;
import com.sky.readygo.infrastructure.manager.GeneratorConfigManager;
import com.sky.readygo.infrastructure.manager.SchemaManager;
import com.sky.readygo.infrastructure.pojo.dto.GeneratorConfigDto;
import com.sky.readygo.infrastructure.pojo.dto.SchemaInfoDto;
import com.sky.readygo.service.GeneratorConfigService;
import com.sky.readygo.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorConfigServiceImpl implements GeneratorConfigService {

    @Autowired
    private GeneratorConfigManager generatorConfigManager;

    @Override
    public void save(GeneratorConfigDto generatorConfigDto) throws ServiceException {
        generatorConfigManager.insertSelective(BeanMapper.map(generatorConfigDto, GeneratorConfig.class));
    }

    @Override
    public GeneratorConfigDto getById(Long id) throws ServiceException {
        return BeanMapper.map(generatorConfigManager.selectByKey(id), GeneratorConfigDto.class);
    }
}