package com.sky.readygo.service;

import com.sky.readygo.infrastructure.pojo.dto.AppDto;

import java.util.List;

public interface AppService {
    List<AppDto> getAll();

    AppDto getOne();
}