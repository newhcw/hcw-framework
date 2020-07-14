package com.hcw.framework.design.pattern.visitor;

public class CommonCustomer extends Customer {
    @Override
    public void accept(Visitor visitor) {
        visitor.callBack();
    }
}
