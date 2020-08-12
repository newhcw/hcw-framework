package com.hcw.framework.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IntefaceProxy implements InvocationHandler {

    // HelloImpl hello; 被代理对象

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //return method.invoke(this, args);
        //rpc调用
        //System.out.println("invoke");
        return null;
    }
}
