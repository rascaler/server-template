package com.sky.template.infrastructure.manager.impl;

import com.sky.template.infrastructure.domain.App;
import com.sky.template.infrastructure.manager.AppManager;
import com.sky.template.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class AppManagerImpl extends DefaultManager<App> implements AppManager {
}