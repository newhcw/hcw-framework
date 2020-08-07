package com.hcw.learn.mybatis.mapper;

import org.apache.ibatis.binding.MapperMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapperProxy {


    public CourseMapper newInstance(Class<CourseMapper> courseMapperClass) {
        return (CourseMapper) Proxy.newProxyInstance(MapperProxy.class.getClassLoader(), new Class[]{CourseMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(String.format("invoke proxy:%s  method:%s,args:%s",method.getDeclaringClass(),method,args[0]));
                //new MapperMethod(method.getDeclaringClass(),method,config).execute(sqlSession,args);
                return null;
            }
        });
    }

    public static void main(String[] args) {
        CourseMapper x = (CourseMapper) new MapperProxy().newInstance(CourseMapper.class);
        System.out.println(x.getOne(1l));
    }

}
