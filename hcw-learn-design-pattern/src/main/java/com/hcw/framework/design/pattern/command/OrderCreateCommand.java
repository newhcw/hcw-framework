package com.hcw.framework.design.pattern.command;

public class OrderCreateCommand implements OrderOperatorCommand {

    private CreateOrderExecuter createOrderExecuter = new CreateOrderExecuter();

 
    @Override
    public void exec() {
        createOrderExecuter.createOrder();
    }
    
}