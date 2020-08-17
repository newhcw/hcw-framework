package com.hcw.framework.mybatis.plus.binding;

import com.hcw.framework.mybatis.plus.session.SqlSession;

import java.lang.reflect.Proxy;

public class MapperProxyFactory<T> {

    public T newInstance(Class<T> clazz, SqlSession sqlSession) {
        return  (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }
}
