package com.hcw.learn.jdk;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {
        TestPool testPool = new TestPool();
        for (int i = 0; i < 10000; i++) {
            testPool.submit(new Runnable(){

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":11");
                    return;
                }
            });
        }


    }

    static class TestPool{

        private ExecutorService executorService = new ThreadPoolExecutor(10,10,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(1),new ThreadPoolExecutor.CallerRunsPolicy());

        TestPool()  {
            ThreadPoolExecutor tpe = ((ThreadPoolExecutor) executorService);
            while (true){
                System.out.println("当前活跃线程数:"+tpe.getActiveCount());
                System.out.println("当前排队线程数:"+tpe.getQueue().size());
                System.out.println("执行完成线程数:"+tpe.getCompletedTaskCount());

                long taskCount = tpe.getTaskCount();
                System.out.println("总线程数：" + taskCount);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Future submit(Runnable task) {
            return executorService.submit(task);
        }

    }
}
