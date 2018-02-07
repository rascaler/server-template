package com.sky.template.service;

import com.sky.template.infrastructure.pojo.dto.AppDto;

import java.util.List;

public interface AppService {
    List<AppDto> getAll();

    AppDto getOne();
}