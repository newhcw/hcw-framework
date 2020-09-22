package com.hcw.framework.design.pattern.proxy;

import java.lang.reflect.Proxy;

public class IntefaceProxyFactory2 {


// 动态创建一个代理对象类
    public Object newProxyInstance(Class[] interfaceClass){
        IntefaceProxy intefaceProxy = new IntefaceProxy();
        return Proxy.newProxyInstance(interfaceClass[0].getClassLoader() ,
                interfaceClass , intefaceProxy);

    }
}
