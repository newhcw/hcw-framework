package com.hcw.framework.design.pattern.command;

public class OrderPayCommand implements OrderOperatorCommand {

    OrderPayExecuter orderPayExecuter = new OrderPayExecuter();

   

    @Override
    public void exec() {
        orderPayExecuter.pay();
        
    }
    
}