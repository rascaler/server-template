package com.sky.readygo.service;


import com.sky.commons.utils.exception.ServiceException;
import com.sky.readygo.infrastructure.pojo.dto.GeneratorConfigDto;

public interface GeneratorConfigService {

    void save(GeneratorConfigDto generatorConfigDto) throws ServiceException;

    GeneratorConfigDto getById(Long id) throws ServiceException;
}