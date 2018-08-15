package com.sky.stock.infrastructure.manager.impl;

import com.sky.stock.infrastructure.utils.DefaultManager;
import com.sky.stock.infrastructure.domain.App;
import com.sky.stock.infrastructure.manager.AppManager;
import org.springframework.stereotype.Service;

@Service
public class AppManagerImpl extends DefaultManager<App> implements AppManager {
}