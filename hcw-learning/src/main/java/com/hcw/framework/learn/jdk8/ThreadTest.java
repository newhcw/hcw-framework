package com.hcw.framework.learn.jdk8;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("i am live");
                }
            }
        }).start();

        Thread.sleep(10000000000l);
        //System.exit(-1);
    }
}
