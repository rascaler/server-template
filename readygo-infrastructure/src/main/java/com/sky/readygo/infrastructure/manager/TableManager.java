package com.sky.readygo.infrastructure.manager;

import com.sky.readygo.infrastructure.domain.Schema;
import com.sky.readygo.infrastructure.pojo.dto.TableDto;
import com.sky.readygo.infrastructure.utils.BaseManager;

import java.util.List;

public interface TableManager {

    List<TableDto> listTables (Long dataSourceId, String schemaName);
}