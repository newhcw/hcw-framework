package com.hcw.framework.jdk8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {


    /**
     * 如果指定的键尚未与值关联，则尝试使用给定的映射函数计算其值，除非为null，否则将其输入此映射
     * 整个方法调用是原子执行的
     * @param args
     */
    @Test
    public void testComputeIfAbsent() {
        ConcurrentHashMap<Object, Object> locks = new ConcurrentHashMap<>();
        locks.put("1","1");
        Assertions.assertEquals("1", locks.computeIfAbsent("1", v -> {
            return "2";
        }));
    }



}
