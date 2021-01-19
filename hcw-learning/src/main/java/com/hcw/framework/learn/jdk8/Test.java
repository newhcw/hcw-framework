package com.hcw.framework.learn.jdk8;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> args1 = List.of(args);

        while (args1.size()> 0) {
            List.of(args).stream().forEach(v-> System.out.println(v));
            break;
        }

    }
}
