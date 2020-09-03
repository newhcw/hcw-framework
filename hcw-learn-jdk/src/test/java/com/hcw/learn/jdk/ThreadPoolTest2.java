package com.hcw.learn.jdk;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class ThreadPoolTest2 {

    static Logger logger = LoggerFactory.getLogger(ThreadPoolTest2.class);

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(1,1,0L,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1), new ThreadFactory() {
                    @Override
                    public Thread newThread(@NotNull Runnable r) {
                        return new Thread(r, "t1_pl_pool_" + r.hashCode());
                    }
                },new ThreadPoolExecutor.CallerRunsPolicy());
        ExecutorService executorService2 = new ThreadPoolExecutor(1,1,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(1),new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    executorService2.submit(new Runnable() {
                        @Override
                        public void run() {
                            logger.info(Thread.currentThread().getName());
                        }
                    });
                }
            });
        }


    }


}
