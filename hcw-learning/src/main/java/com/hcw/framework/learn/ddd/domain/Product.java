package com.hcw.framework.learn.ddd.domain;

import java.math.BigDecimal;

public class Product {

    static {
        System.out.println("Product 由"+Order.class.getClassLoader().getName()+"类加载器加载成功,");
    }

    private String id;

    private String no;

    private String proName;

    private BigDecimal price;
}
