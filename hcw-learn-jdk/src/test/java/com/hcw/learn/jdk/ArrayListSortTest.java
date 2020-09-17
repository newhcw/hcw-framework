package com.hcw.learn.jdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArrayListSortTest {


    List<Integer> list = new ArrayList<>();
    List<User> users = new ArrayList<>();

    @BeforeEach
    public void preData() {
        System.out.println("-");
        for (int i = 0; i < 10; i++) {
            list.add(i*2+ new Random().nextInt(100));
            users.add(new User("xiao ming"+i,+ new Random().nextInt(100)));
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
        list.sort(Comparator.reverseOrder());//倒序
        list.forEach(System.out::println);
        System.out.println("=======================");
        list.sort(Comparator.naturalOrder());//正序
        list.forEach(System.out::println);
    }


    @Test
    public void testObjectListSort() {
        users.sort(Comparator.comparing(User::getAge));// 正序
        users.forEach(System.out::println);
        System.out.println("=======================");

        users.sort(Comparator.comparing(User::getAge).reversed());// 倒序
        users.forEach(System.out::println);
    }
}
