package com.hcw.framework.design.pattern.visitor;

/**
 * 访问者模式,对于数据结构稳定的系统,新增功能.
 * 隔离了数据结构,与行为实现 符合开闭原则,符合依赖倒置
 */
public class Client {

    public static void main(String[] args) {

        Visitor worthAnalysistVisitor = new WorthAnalysistVisitor();//添加价值分析功能
        EnterpriceCustomer enterpriceCustomer = new EnterpriceCustomer();
        enterpriceCustomer.accept(worthAnalysistVisitor);

        // add 产品偏好功能
        ProductPreferVisitor productPreferVisitor = new ProductPreferVisitor();
        enterpriceCustomer.accept(productPreferVisitor);

    }
}
