package com.hcw.framework.design.pattern.factory;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    public Map<String,Object> getBeansWithAnnotation(Class<?> annotationType);

    
}