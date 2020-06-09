package com.hcw.framework.design.pattern.strategy;

public class Client {

    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        context.exect();
    }
}
