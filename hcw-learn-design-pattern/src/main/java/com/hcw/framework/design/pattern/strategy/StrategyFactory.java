package com.hcw.framework.design.pattern.strategy;

public class StrategyFactory {

    public Strategy getStrategy(String opt) {
        if (opt.equals("+")) {
            return new AddStrategy();
        }
        if (opt.equals("*")) {
            return new MultStrategy();
        }
        return null;
    }
}
