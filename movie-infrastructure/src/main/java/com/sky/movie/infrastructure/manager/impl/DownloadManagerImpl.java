package com.sky.movie.infrastructure.manager.impl;

import com.sky.movie.infrastructure.domain.Download;
import com.sky.movie.infrastructure.manager.DownloadManager;
import com.sky.movie.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class DownloadManagerImpl extends DefaultManager<Download> implements DownloadManager {
}