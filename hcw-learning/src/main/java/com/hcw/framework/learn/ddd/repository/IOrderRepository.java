package com.hcw.framework.learn.ddd.repository;

import java.util.List;

import com.hcw.framework.learn.ddd.domain.Order;

public interface IOrderRepository {

	List<Order> getOrderList(String custId);
    
}