package com.hcw.framework.learn.jdk8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 数值转换器
 */
public class NumberUtils {

    public static BigDecimal  toBigDecimal(Object value,BigDecimal defaultValue){
        if (value == null) return defaultValue;
        return new BigDecimal(value.toString());
    }

    public static BigDecimal toBigDecimal(Object value){
        return toBigDecimal(value, BigDecimal.ZERO);
    }


    public static void main(String[] args) {
        List<Map<String, String>> a = Collections.emptyList();
        a.add(Map.of("key","a"));
        List<Map<String, String>> result = new ArrayList<>();
        result.add(Map.of("key","b"));
        result.stream().filter(m ->m.get("key").equals("b")).findFirst().ifPresent(m -> {a.add(m);
            System.out.println(a);});
        a.stream().forEach(System.out::println);
    }
}
