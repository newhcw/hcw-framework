package com.hcw.framework.learn.ddd.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hcw.framework.learn.ddd.repository.IProductRepository;



public class Order {
    private static int i=2;
    static {
        System.out.println("Order由"+Order.class.getClassLoader().getName()+"类加载器加载成功,");
        System.out.println(i);
    }
    public Order(){
        System.out.println("构造函数执行");
        System.out.println(i);
    }

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