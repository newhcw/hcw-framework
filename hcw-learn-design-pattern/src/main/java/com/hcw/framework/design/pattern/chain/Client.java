package com.hcw.framework.design.pattern.chain;

public class Client {

    public static void main(String[] args) {
        Handle masterHandle = new DepMasterHandle();
        masterHandle.setNextHandle(new HrHandle());
        masterHandle.handle(Request.builder().holidayDays(20).build());
    }
}
