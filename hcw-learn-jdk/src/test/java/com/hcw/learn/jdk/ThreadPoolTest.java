package com.hcw.learn.jdk;

import java.util.concurrent.*;

/**
 * 线程池监控
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        TestPool testPool = new TestPool();
        for (int i = 0; i < 5; i++) {
            work(testPool);
            Thread.currentThread().sleep(1000*10);
        }


    }

    static void work(TestPool testPool) {
        String mainThreadName = Thread.currentThread().getName();

        for (int i = 0; i < 10; i++) {
            try {
                testPool.submit(new Callable<Object>() {

                    @Override
                    public Object call() {
                        try{
                            String name = Thread.currentThread().getName();
                            int b = Integer.valueOf("21");
                            int i1 = Integer.parseInt("0.11");
                            int a = Integer.getInteger("");
                        }catch (Exception e){
                            if (mainThreadName.equals(Thread.currentThread().getName())){
                                System.out.println(Thread.currentThread().getName()+";"+e.getStackTrace());
                            }
                        }
                        return "";
                    }
                });
            } catch (Exception e) {

                System.out.println(Thread.currentThread().getName()+";"+e.getStackTrace());
            }


        }
    }

    static class TestPool{

        private ExecutorService executorService = new MyThreadPoolExecutor(50,50,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(8000),new ThreadPoolExecutor.CallerRunsPolicy());

        TestPool()  {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    monitor();
                }
            }).start();

        }

        public Future submit( Callable task) {
            return executorService.submit(task);
        }

        private void monitor() {
            ThreadPoolExecutor tpe = ((ThreadPoolExecutor) executorService);
            while (true){
                System.out.println("================================");
                System.out.println("当前线程池中正在执行任务的线程数量:"+tpe.getActiveCount());
                System.out.println("创建过的最大线程数:"+tpe.getMaximumPoolSize());
                System.out.println("线程池当前的线程数量:"+tpe.getPoolSize());
                System.out.println("当前排队线程数:"+tpe.getQueue().size());
                System.out.println("执行完成任务数:"+tpe.getCompletedTaskCount());

                long taskCount = tpe.getTaskCount();
                System.out.println("总任务数：" + taskCount);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class MyThreadPoolExecutor extends ThreadPoolExecutor{


        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            super.beforeExecute(t, r);
            System.out.println("thread t will run task r");
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            System.out.println("thread t will runed task r");
        }

        @Override
        protected void terminated() {
            super.terminated();
            System.out.println("thread terminated");
        }
    }
}
