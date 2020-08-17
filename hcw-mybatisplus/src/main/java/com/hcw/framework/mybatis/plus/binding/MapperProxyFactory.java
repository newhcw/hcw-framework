package com.hcw.framework.mybatis.plus.binding;

import java.lang.reflect.Proxy;

public class MapperProxyFactory<T> {

    public T newInstance(Class<T> clazz) {
        return  (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MapperProxy());
    }
}
