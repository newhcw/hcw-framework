package com.hcw.framework.learn.ddd.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hcw.framework.learn.ddd.repository.IProductRepository;



public class Order {

    private Long orderId;

    private BigDecimal price;

    private Date createDate;

    private Customer customer;

    private BigDecimal discountPrice;

    private List<Product> productList;

    IProductRepository productRepository;

    public List<Product> getProductList(Long orderId){
        return productRepository.getProductList(orderId);
    }

    public static Boolean checkRepeatCreateOrder(){
        return true;
    }
}