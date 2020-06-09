package com.hcw.framework.design.pattern.chain;

public class HrHandle extends Handle{


    @Override
    public void handle(Request request) {
        if (request.getHolidayDays()>=3){
            System.out.println("hr is passing");
        }else {
            getNextHandle().handle(request);
        }
    }
}
