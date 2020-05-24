package com.hcw.framework.design.pattern.factory;

public interface HierarchicalBeanFactory extends BeanFactory {
    
    BeanFactory getParentFactory();
}