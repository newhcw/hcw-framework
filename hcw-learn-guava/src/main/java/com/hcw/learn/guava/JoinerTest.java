package com.hcw.learn.guava;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.List;

public class JoinerTest {

    public static void main(String[] args) {
        List<String> arrayList = Arrays.asList("2","3","4","5");
        List<String> nullList = Arrays.asList("2",null,"4","5");
        System.out.println(Joiner.on(",").join(arrayList));
        //如果序列中包含 null 值，那么可以使用 Joiner 跳过 null 值
        System.out.println(Joiner.on(";").skipNulls().join(nullList));
        //也可以通过 useForNull(String) 来将 null 值替换为指定的字符串。
        System.out.println(Joiner.on(";").useForNull("空").join(nullList));


    }
}
