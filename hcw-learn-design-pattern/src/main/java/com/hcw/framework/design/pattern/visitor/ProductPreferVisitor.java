package com.hcw.framework.design.pattern.visitor;

public class ProductPreferVisitor implements Visitor {
    @Override
    public void callBack() {
        System.out.println("开始产品偏好分析");
    }
}
