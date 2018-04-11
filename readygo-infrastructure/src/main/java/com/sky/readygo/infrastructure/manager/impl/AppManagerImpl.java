package com.sky.readygo.infrastructure.manager.impl;

import com.sky.readygo.infrastructure.domain.App;
import com.sky.readygo.infrastructure.manager.AppManager;
import com.sky.readygo.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class AppManagerImpl extends DefaultManager<App> implements AppManager {
}