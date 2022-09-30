package com.hcw.framework.jdk8;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.blade.kit.UncheckedFnKit;

public class Test {


    public static void main(String[] args) {
//        Class caller = Arrays.stream(Thread.currentThread().getStackTrace())
//        .filter(st -> "main".equals(st.getMethodName()))
//        .findFirst()
//        .map(StackTraceElement::getClassName)
//        .map(UncheckedFnKit.function(Class::forName))
//        .orElse(null);
//
//
//        Map map = new HashMap<>();
//        map.put(1, 1);
//        System.out.println(map.size());

        System.out.println(LocalDateTime.now().minusHours(0).getSecond());

    }
    
}