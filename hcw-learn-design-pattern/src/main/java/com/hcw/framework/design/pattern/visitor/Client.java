package com.hcw.framework.design.pattern.visitor;

/**
 * 访问者模式,对于数据结构稳定的系统,新增功能.
 * 隔离了数据结构,与行为实现 符合开闭原则,符合依赖倒置
 */
public class Client {

    public static void main(String[] args) {

        // 企业用户
        EnterpriceCustomer enterpriceCustomer = new EnterpriceCustomer();
        // 普通用户
        CommonCustomer commonCustomer = new CommonCustomer();

        // add 产品偏好分析功能
        ProductPreferVisitor productPreferVisitor = new ProductPreferVisitor();
        // 给企业用户添加产品偏好分析功能
        enterpriceCustomer.accept(productPreferVisitor);
        // 给普通用户添加产品偏好分析功能
        commonCustomer.accept(productPreferVisitor);

        //添加价值分析功能
        Visitor worthAnalysistVisitor = new WorthAnalysistVisitor();
        // 给企业用户添加价值分析功能
        enterpriceCustomer.accept(worthAnalysistVisitor);
        // 给普通用户添加价值分析功能
        commonCustomer.accept(worthAnalysistVisitor);
    }
}
