package com.hcw.framework.design.pattern.proxy;

public class Test {
    public static void main(String[] args) {
        IntefaceProxyFactory intefaceProxyFactory = new IntefaceProxyFactory();
        IHello hello = (IHello) intefaceProxyFactory.newProxyInstance(IHello.class);
        hello.sayHi();
    }
}
