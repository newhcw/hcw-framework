package com.hcw.framework.design.pattern.strategy;

public class Context {

    private  Strategy strategy;


    public  Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void exect(){
        strategy.excute();
    }
}
