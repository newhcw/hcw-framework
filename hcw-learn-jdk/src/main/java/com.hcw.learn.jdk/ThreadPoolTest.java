package com.hcw.learn.jdk;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.SneakyThrows;

import java.util.concurrent.*;

public class ThreadPoolTest {
    static MyArrayBlockQueue myArrayBlockQueue = new MyArrayBlockQueue(10);

    static ExecutorService  threadPool = new MyThreadPoolExecutor(9, 10,
            0, TimeUnit.SECONDS,
            myArrayBlockQueue,
            new ThreadFactoryBuilder().setNameFormat("my-thread-%d").build(),
            new MyRejectedExecutionHandler());

    public static void main(String[] args) throws InterruptedException {


        for (;;
             ) {
            threadPool.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    MyThreadPoolExecutor threadPoolExecutor = (MyThreadPoolExecutor) threadPool;

                    System.out.println("运行-"+threadPoolExecutor.toString());
                    Thread.currentThread().sleep(1000*1);
                }
            });
        }
        //Thread.currentThread().sleep(1000*9);
        //threadPool.shutdown();

    }

    static class MyThreadPoolExecutor extends ThreadPoolExecutor{


        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }


        @Override
        protected void terminated() {
            System.out.println("close threadPool");
            super.terminated();
        }
    }


    static class MyArrayBlockQueue extends ArrayBlockingQueue{

        public MyArrayBlockQueue(int capacity) {
            super(capacity);
        }

        @Override
        public boolean offer(Object o) {
            MyThreadPoolExecutor threadPoolExecutor = (MyThreadPoolExecutor) threadPool;
            if (threadPoolExecutor.getActiveCount()==threadPoolExecutor.getMaximumPoolSize()){
                return super.offer(o);
            }else {
                return false;
            }

        }
    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("拒绝-"+executor.toString());
            myArrayBlockQueue.offer(r);
            //r.run();
        }
    }
}
