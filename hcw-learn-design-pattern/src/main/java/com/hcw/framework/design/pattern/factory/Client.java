package com.hcw.framework.design.pattern.factory;

import com.hcw.framework.design.pattern.entity.Pizza;

/**
 * 工厂模式,需要知道具体的实现细节,
 */
public class Client {

    public static void main(String[] args) {
        BeanFactory beanFactory = new SimpleBeanFactory();
        Pizza pizza = (Pizza) beanFactory.getBean("com.hcw.framework.design.pattern.entity.Pizza");
        System.out.println(pizza);
    }
    
}