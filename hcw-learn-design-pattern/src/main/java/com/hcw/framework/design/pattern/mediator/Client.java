package com.hcw.framework.design.pattern.mediator;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        mediator.run();

    }
}
