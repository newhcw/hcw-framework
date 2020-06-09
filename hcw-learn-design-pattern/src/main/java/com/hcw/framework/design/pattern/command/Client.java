package com.hcw.framework.design.pattern.command;

/**
 * 策略模式:屏蔽了 请求者 与  执行者.解耦了.
 * 对请求者的是invoke对象.
 */
public class Client {


    public static void main(String[] args) {
        OrderInvoke orderInvoke = new OrderInvoke(new OrderCreateCommand());
        orderInvoke.invoke();
    }
    
}