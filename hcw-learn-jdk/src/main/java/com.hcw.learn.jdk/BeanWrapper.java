package com.hcw.learn.jdk;

import java.lang.reflect.Method;
import java.util.HashMap;

public class BeanWrapper {

    public Object getValue(Object o,String property) throws Exception {
        Method[] methods = o.getClass().getMethods();

        HashMap<Object, Method> methodMap = new HashMap<Object, Method>();
        Method method = methodMap.get(property);
        return method.invoke(o,property);
    }
}
