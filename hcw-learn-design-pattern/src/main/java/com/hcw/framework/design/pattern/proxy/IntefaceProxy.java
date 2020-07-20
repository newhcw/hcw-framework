package com.hcw.framework.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IntefaceProxy implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //return method.invoke(this, args);
        System.out.println("sss");
        return null;
    }
}
