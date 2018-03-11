package com.sky.movie.infrastructure.manager.impl;

import com.sky.movie.infrastructure.domain.Statistics;
import com.sky.movie.infrastructure.manager.StatisticsManager;
import com.sky.movie.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class StatisticsManagerImpl extends DefaultManager<Statistics> implements StatisticsManager {
}