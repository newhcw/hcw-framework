package com.hcw.framework.learn.ddd.domain;

import java.util.List;

import com.hcw.framework.learn.ddd.repository.IOrderRepository;

public class Customer {

    IOrderRepository orderRepositoy;


    public List<Order> getOrderList(String custId){
        return orderRepositoy.getOrderList(custId);
    }
}
