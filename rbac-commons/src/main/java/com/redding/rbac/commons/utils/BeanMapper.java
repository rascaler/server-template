/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.io
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.sky.rbac.commons.utils;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

/**
 * 简单封装orika, 实现深度转换Bean<->Bean的Mapper.
 */
public class BeanMapper {

    private static MapperFacade mapper = null;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapper = mapperFactory.getMapperFacade();

    }

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <S, D> D map(S source, Class<D> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
        return sourceList != null ? mapper.mapAsList(sourceList, destinationClass) : null;
    }
}