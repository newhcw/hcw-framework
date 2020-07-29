package com.hcw.framework.learn.jdk8;

import java.util.Arrays;

public class ArraysTest2 {

    /**
     * 数组添加元素
     * @param args
     */
    public static void main(String[] args) {
        String[] arr = {"1", "3", "4"};
        String s = "3";
        int index = Arrays.binarySearch(arr, s);
        System.out.println(index);
        if (index > -1) {
            String[] copyOf = Arrays.copyOf(arr, arr.length + 1);
            copyOf[copyOf.length] = s;
        }
    }
}

