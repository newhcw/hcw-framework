package com.hcw.framework.learn.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stream {
    public static void main(final String[] args) {
        final List list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        System.out.println("origin list size:" + list.size());

        List unSafeList = new ArrayList<>();
        list.parallelStream().forEach(unSafeList::add);
       
        System.out.println("cur list size:"+unSafeList.size());

        Long  begin = System.currentTimeMillis();
        List safeList = Collections.synchronizedList(new ArrayList<>());
        list.parallelStream().forEach(safeList::add);
        Long end = System.currentTimeMillis();
        System.out.println("use parallelStream total cost time is "+(end - begin));

        System.out.println("cur list size:"+safeList.size());
        safeList.clear();
          begin = System.currentTimeMillis();
        list.stream().forEach(safeList::add);
         end = System.currentTimeMillis();
        System.out.println("use stream total cost time is "+(end - begin));
    }
}