package com.hcw.framework.learn.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * 踩坑指南
 * ArrayList.as 使用的是内部类ArrayList,跟jdk包的ArrayList注意区分.
 * 二种实现方式相似,只是内部类arraylist 没有override add()方法,会禁止add
 */
public class ArraysTest {
    public static void main(String[] args) {
        List list = Arrays.asList("1", "3", "4");
        //list.add("e");
        Spliterator spliterator = list.spliterator();
        System.out.println(spliterator.estimateSize());
        System.out.println(spliterator.getExactSizeIfKnown());
        System.out.println(spliterator.characteristics());


        List a = new ArrayList();
        a.stream().map(t->t=0).collect(Collectors.toList());
    }
}
