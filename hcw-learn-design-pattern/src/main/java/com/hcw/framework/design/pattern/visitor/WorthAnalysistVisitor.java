package com.hcw.framework.design.pattern.visitor;

public class WorthAnalysistVisitor implements Visitor{
    @Override
    public void callBack() {
        System.out.println("开始价值分析");
    }
}
