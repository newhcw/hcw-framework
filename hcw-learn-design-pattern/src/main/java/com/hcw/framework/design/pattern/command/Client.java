package com.hcw.framework.design.pattern.command;

public class Client {


    public static void main(String[] args) {
        OrderInvoke orderInvoke = new OrderInvoke(new OrderCreateCommand());
        orderInvoke.invoke();
    }
    
}