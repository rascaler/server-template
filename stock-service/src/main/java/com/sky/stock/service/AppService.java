package com.sky.stock.service;

import com.sky.stock.infrastructure.pojo.dto.AppDto;

import java.util.List;

public interface AppService {
    List<AppDto> getAll();

    AppDto getOne();
}