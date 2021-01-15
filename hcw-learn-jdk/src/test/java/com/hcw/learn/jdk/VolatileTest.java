package com.hcw.learn.jdk;

public class VolatileTest {


    static volatile int i = 0;


    public static void main(String[] args) {


        new Thread(()->{
            i = 2;
        }).start();


        new Thread(()->{
            System.out.println(i);
        }).start();
    }

}
