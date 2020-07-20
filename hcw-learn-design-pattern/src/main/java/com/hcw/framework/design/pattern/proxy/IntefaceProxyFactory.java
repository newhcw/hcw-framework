package com.hcw.framework.design.pattern.proxy;

import java.lang.reflect.Proxy;

public class IntefaceProxyFactory {


// 动态创建一个代理对象类
    public Object newProxyInstance(Class interfaceClass){
        IntefaceProxy intefaceProxy = new IntefaceProxy();
        return Proxy.newProxyInstance(interfaceClass.getClassLoader() ,
                new Class[]{interfaceClass} , intefaceProxy);
    }
}
