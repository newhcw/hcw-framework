package com.hcw.framework.design.pattern.decorator;

import java.util.ArrayList;
import java.util.List;

public class ConcreateDecorator implements Decorator{


    private Component componet;


    public ConcreateDecorator(Component componet){
        this.componet = componet;
    }

    @Override
    public List<Object> queryList(){
        // 先查询cache
        this.queryListFromCache();// 装饰者模式，就是在被装饰的对象调用的时候，扩展额外的功能
        return componet.queryList();
    }

    private List<Object> queryListFromCache(){
        System.out.println("query data from cache");
        return new ArrayList<>();
    }
    
}