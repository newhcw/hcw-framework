package com.hcw.framework.design.pattern.strategy;

/*
策略模式 替代了继承。
将类的行为，给解藕了。
 */
public class Context {

    private  Strategy strategy;


    public  Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void exect(){
        strategy.excute();
    }
}
