package com.hcw.framework.learn.ddd.service;

import com.hcw.framework.learn.ddd.domain.Order;
import com.hcw.framework.learn.ddd.valueObject.CreateOrder;

public class CreateOrderService {

    

    public void createOrder(CreateOrder createOrder){
        if(!Order.checkRepeatCreateOrder()){
            System.out.println("重单");
        }
    }
    
}