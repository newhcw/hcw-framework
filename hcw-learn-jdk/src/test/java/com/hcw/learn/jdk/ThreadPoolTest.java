package com.hcw.learn.jdk;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {
        String mainThreadName = Thread.currentThread().getName();
        TestPool testPool = new TestPool();
        TestPool testPool2 = new TestPool();
        testPool2.submit(new Callable() {
            @Override
            public Object call() throws Exception {

                for (int i = 0; i < 9*10000; i++) {
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
//                                    if (mainThreadName.equals(Thread.currentThread().getName())){
//                                        System.out.println(Thread.currentThread().getName()+";"+e.getStackTrace());
//                                    }
                                }


                                return "";
                            }
                        });
                    } catch (Exception e) {

                        System.out.println(Thread.currentThread().getName()+";"+e.getStackTrace());
                    }


                }


                return null;
            }
        });



        Long now = System.currentTimeMillis();

        System.out.println("total cost is "+(System.currentTimeMillis()-now)/1000 +"s");

    }

    static class TestPool{

        private ExecutorService executorService = new ThreadPoolExecutor(50,50,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(8000),new ThreadPoolExecutor.CallerRunsPolicy());

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
}
