package com.hcw.framework.design.pattern.adapter;

public class Client {

    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        Target target =  new Adapter(adaptee);
        target.request();
    }

}
