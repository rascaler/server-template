package com.sky.stock.infrastructure.manager.impl;

import com.sky.stock.infrastructure.domain.Kline;
import com.sky.stock.infrastructure.manager.KlineManager;
import com.sky.stock.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class KlineManagerImpl extends DefaultManager<Kline> implements KlineManager {
}