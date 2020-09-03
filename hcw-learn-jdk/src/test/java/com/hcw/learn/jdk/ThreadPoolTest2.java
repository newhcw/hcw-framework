package com.hcw.learn.jdk;

import java.util.concurrent.*;

public class ThreadPoolTest2 {

    public static void main(String[] args) {
         ExecutorService executorService = new ThreadPoolExecutor(1,1,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(1),new ThreadPoolExecutor.CallerRunsPolicy());
        ExecutorService executorService2 = new ThreadPoolExecutor(1,1,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(1),new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("fisrt");
                    executorService2.submit(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName());
                        }
                    });
                }
            });
        }


    }


}
