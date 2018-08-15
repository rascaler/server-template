package com.sky.readygo.infrastructure.manager.impl;

import com.sky.readygo.infrastructure.domain.Schema;
import com.sky.readygo.infrastructure.manager.SchemaManager;
import com.sky.readygo.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class SchemaManagerImpl extends DefaultManager<Schema> implements SchemaManager {
}