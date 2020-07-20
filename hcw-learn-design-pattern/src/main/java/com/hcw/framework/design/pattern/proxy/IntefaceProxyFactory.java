package com.hcw.framework.design.pattern.proxy;

import java.lang.reflect.Proxy;

public class IntefaceProxyFactory {
    IntefaceProxy intefaceProxy = new IntefaceProxy();

// 动态创建一个代理对象类
    public Object newProxyInstance(Class interfaceClass){
        return Proxy.newProxyInstance(interfaceClass.getClassLoader() ,
                interfaceClass.getInterfaces() , intefaceProxy);
    }
}
