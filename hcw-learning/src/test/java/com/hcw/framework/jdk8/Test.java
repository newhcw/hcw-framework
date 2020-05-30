package com.hcw.framework.jdk8;

import java.util.Arrays;

import com.blade.kit.UncheckedFnKit;

public class Test {


    public static void main(String[] args) {
        Class caller = Arrays.stream(Thread.currentThread().getStackTrace())
        .filter(st -> "main".equals(st.getMethodName()))
        .findFirst()
        .map(StackTraceElement::getClassName)
        .map(UncheckedFnKit.function(Class::forName))
        .orElse(null);
    }
    
}