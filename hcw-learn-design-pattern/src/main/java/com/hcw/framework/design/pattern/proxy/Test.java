package com.hcw.framework.design.pattern.proxy;

public class Test {
    public static void main(String[] args) {
        IntefaceProxyFactory intefaceProxyFactory = new IntefaceProxyFactory();
        IHello hello = (IHello) intefaceProxyFactory.newProxyInstance(IHello.class);
        hello.sayHi();

        IntefaceProxyFactory intefaceProxyFactory2 = new IntefaceProxyFactory();
        IHello2 hello2 = (IHello2) intefaceProxyFactory2.newProxyInstance(IHello2.class);
        hello2.sayHello();

        // 如果需要又说hi，又说hello，则没办法了。
        IntefaceProxyFactory2 intefaceProxyFactory21 = new IntefaceProxyFactory2();
        Object o = intefaceProxyFactory21.newProxyInstance(new Class[]{IHello.class, IHello2.class});

    }
}
