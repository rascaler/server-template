package com.sky.template.service.impl;

import com.sky.commons.utils.bean.BeanMapper;
import com.sky.template.infrastructure.manager.AppManager;
import com.sky.template.infrastructure.pojo.dto.AppDto;
import com.sky.template.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppManager appManager;
    @Override
    public List<AppDto> getAll() {
        return BeanMapper.mapList(appManager.selectAll(), AppDto.class);
    }

    @Override
    public AppDto getOne() {
        return null;
    }
}