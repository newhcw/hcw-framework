package com.hcw.framework.design.pattern.chain;

public class ManagerHandle extends Handle{

    @Override
    public void handle(Request request) {
        if (request.getHolidayDays()>=10){
            System.out.println("manager passing");
        }else {
            getNextHandle().handle(request);
        }
    }
}
