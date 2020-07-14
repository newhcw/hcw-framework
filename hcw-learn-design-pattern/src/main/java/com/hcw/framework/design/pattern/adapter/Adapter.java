package com.hcw.framework.design.pattern.adapter;

public class Adapter implements Target {


    Adaptee adaptee;

    public Adapter(Adaptee adapter) {
        this.adaptee = adapter;
    }

    @Override
    public void request() {
        adaptee.specialRequest();
    }
}
