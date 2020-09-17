package com.hcw.learn.jdk;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayListSortTest {


     List<Integer> list = new ArrayList<>();

    @BeforeEach
    public void preData() {
        System.out.println("-");
        for (int i = 0; i < 10; i++) {
            list.add(i*2+ new Random().nextInt(100));
        }
    }

    @Test
    public void testArray() {
        Object[] objects = list.toArray();
        Arrays.sort(objects); // 正序排列,如果倒序排列怎么办??
        for (Object object : objects) {
            System.out.println(object.toString());
        }

    }

    @Test
    public void testLombdaSort() {

    }


}
