package com.hcw.framework.design.pattern.strategy;

/**
 * 策略模式
 * 需要知道具体的策略类,及需要知道实现细节,不符合迪米特法则
 */
public class Client {

    public static void main(String[] args) {
//        Context context = new Context(new AddStrategy());
//        context.exect();

        StrategyFactory strategyFactory = new StrategyFactory();
        strategyFactory.getStrategy("*").excute();

        int i=99;
        int j=19;
    }
}
