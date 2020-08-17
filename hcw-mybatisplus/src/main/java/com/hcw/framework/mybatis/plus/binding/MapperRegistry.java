package com.hcw.framework.mybatis.plus.binding;

import com.hcw.framework.mybatis.plus.session.Configuration;
import com.hcw.framework.mybatis.plus.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    private Configuration configuration;

    private Map<Class<?>, MapperProxyFactory> knownMaps = new HashMap<>();


    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    public void addMapper(Class mapper) {
        knownMaps.put(mapper, new MapperProxyFactory());
    }

    public <T> T getMapper(Class<T> mapperClass, SqlSession sqlSession) {
        MapperProxyFactory mapperProxyFactory = knownMaps.get(mapperClass);
        return (T) mapperProxyFactory.newInstance(mapperClass,sqlSession);
    }
}
