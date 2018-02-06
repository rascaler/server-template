package com.sky.template.service;

import java.util.List;

public interface AppService {
    List<AppDto> getAll();

    AppDto getOne();
}