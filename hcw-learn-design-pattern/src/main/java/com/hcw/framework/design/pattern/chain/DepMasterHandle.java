package com.hcw.framework.design.pattern.chain;

public class DepMasterHandle extends Handle {
    @Override
    public void handle(Request request) {
        if (request.getHolidayDays()<3){
            System.out.println("master is passing");
        }else{
            getNextHandle().handle(request);
        }
    }
}
