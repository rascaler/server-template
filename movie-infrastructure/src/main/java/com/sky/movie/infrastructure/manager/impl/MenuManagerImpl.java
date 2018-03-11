package com.sky.movie.infrastructure.manager.impl;

import com.sky.movie.infrastructure.domain.Menu;
import com.sky.movie.infrastructure.manager.MenuManager;
import com.sky.movie.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class MenuManagerImpl extends DefaultManager<Menu> implements MenuManager {
}