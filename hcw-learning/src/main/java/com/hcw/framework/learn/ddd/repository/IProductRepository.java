package com.hcw.framework.learn.ddd.repository;

import java.util.List;

import com.hcw.framework.learn.ddd.domain.Product;

public interface IProductRepository {

	List<Product> getProductList(Long orderId);
    
}