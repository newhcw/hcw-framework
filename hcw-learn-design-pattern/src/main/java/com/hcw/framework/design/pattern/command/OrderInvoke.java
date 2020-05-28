package com.hcw.framework.design.pattern.command;

public class OrderInvoke {

    private OrderOperatorCommand command;

    public OrderInvoke(OrderOperatorCommand operatorCommand){
        this.command = operatorCommand;
    }
    
    public void invoke(){
        command.exec();
    }
}