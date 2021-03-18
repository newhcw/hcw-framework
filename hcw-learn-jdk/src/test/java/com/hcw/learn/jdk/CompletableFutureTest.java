package com.hcw.learn.jdk;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;


/**
 * Java CompletableFuture 详解
 * Java 8 强大的函数式异步编程辅助类
 * https://colobu.com/2016/02/29/Java-CompletableFuture/#%E4%B8%BB%E5%8A%A8%E5%AE%8C%E6%88%90%E8%AE%A1%E7%AE%97
 */
public class CompletableFutureTest {

    /**
     * 返回已经计算好的CompletedFuture
     */
    @Test
    public void testCompletedFuture() {
        CompletableFuture cf = CompletableFuture.completedFuture("hi");
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }

    @Test
    public void testRunAsync() {
        CompletableFuture cf = CompletableFuture.runAsync(() ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().isDaemon());
            try {
                Thread.currentThread().sleep(1000 * 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(cf.getNow(null));// 立刻返回结果
        System.out.println(cf.join());// 等到异步线程结束，获取结果
    }

    @Test
    public void testThenApplyAsync() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().isDaemon());
            try {
                Thread.currentThread().sleep(1000 * 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s.toUpperCase();
        });
        // thenApply main线程串行执行， thenApplyAsync 异步线程ForkJoinPool.commonPool-worker执行
        System.out.println(cf.getNow(null));
    }

    @Test
    public void testApplyAsyncWithExecutor() {
         ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
            int count = 1;
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "custom-executor-" + count++);
            }
        });


         CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(v->{
             return v.toUpperCase();
         },executor);

        System.out.println(cf.getNow(null));
        System.out.println(cf.join());
    }

    @Test
    public void applyToEitherExample() {
        String original = "Message";
        CompletableFuture cf1 = CompletableFuture.completedFuture(original)
                .thenApplyAsync(s -> s.toUpperCase());
        CompletableFuture cf2 = cf1.applyToEither(
                CompletableFuture.completedFuture(original).thenApplyAsync(s -> s.toLowerCase()),
                s -> s + " from applyToEither");
        //System.out.println(cf2.getNow(null));
        System.out.println(cf2.join());
    }


    /**
     * 计算结果完成时,或者异常后的处理
     */
    @Test
    public void testWhenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture cf = CompletableFuture.supplyAsync(()->{
            //int a = 1/0;
            return getMoreData();
        });

        CompletableFuture future = cf.whenComplete((v, e) -> {
            System.out.println(v);
            System.out.println(e);
        });

        System.out.println(future.get());
    }


    /**
     * 重新攥写，依赖前一个计算结果cf1带入第二个函数cf2计算，
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testThenCompose() throws ExecutionException, InterruptedException {
        // 1.异步获取cars列表
        CompletableFuture<List<Car>> cf = CompletableFuture.supplyAsync(()->{
            return testGetCarList();
        });
        // 通过1的car列表，再并发遍历每一个car 获取分数

        // 这里方法，只能那前一个计算结果，进行后面的运算。
        CompletableFuture<Object> cf2 = cf.thenCompose(cars -> {
            return CompletableFuture.supplyAsync(()->queryScore(cars.get(0).getName()));
        });
        System.out.println(cf2.get());

    }

    /**
     *  2个cf1,cf2 并行进行，计算结果后，再进行fn(cf1,cf2)
     *
     *  其实从功能上来讲,它们的功能更类似thenAcceptBoth，只不过thenAcceptBoth是纯消费，它的函数参数没有返回值，而thenCombine的函数参数fn有返回值
     */
    @Test
    public void testThenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(100);
            return 100;
        });
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(200);
           return 200;
        });

        System.out.println(cf1.thenCombine(cf2, (x, y) -> x + y).get());
    }


    /**
     * allOf方法是当所有的CompletableFuture都执行完后。
     * anyOf方法是当任意一个CompletableFuture执行完后就会执行。
     */
    @Test
    public void testAllof() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(100);
            return 100;
        });
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(200);
            return 200;
        });

        //System.out.println(CompletableFuture.allOf(cf1, cf2).get());
        //System.out.println(CompletableFuture.anyOf(cf1, cf2).get());

        CompletableFuture.allOf(cf1, cf2).get();

    }


    private static Random rand = new Random();
    public int getMoreData() {
        long t = System.currentTimeMillis();
        System.out.println("begin to start compute");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");
        return rand.nextInt(1000);
    }


    @Test
    public void testExample() {
        // 获取car列表
        List<Car> list = this.testGetCarList();
        // 获取每个car的评分
        List<Map<Car, Double>> collect = list.stream().map(v -> {
            double score = queryScore(v.getName());
            return Map.of(v, score);
        }).collect(Collectors.toList());
        // 最终输出car列表，以及评分
        collect.forEach(System.out::println);
    }

    @Test
    public void testExample2() {
        CompletableFuture.completedFuture(null).thenCompose(cars -> {
            var updateCars = testGetCarList().stream().map(car -> queryScore2(car.getName()).thenApply(r -> {
                car.setScore(r);
                return car;
            })).collect(Collectors.toList());

            CompletableFuture<Void> done = CompletableFuture.allOf(updateCars.toArray(new CompletableFuture[updateCars.size()]));
          return   done.thenApply(v -> updateCars.stream().map(CompletionStage::toCompletableFuture)
                    .map(CompletableFuture::join).collect(Collectors.toList()));
        }).whenComplete((cars,th)->{
            if (th == null) {
                cars.forEach(System.out::println);
            } else {
                throw new RuntimeException(th);
            }
        }).toCompletableFuture().join();


    }




    public List<Car> testGetCarList() {
        List<Car> cars = new ArrayList();
        cars.add(new Car("1",0));
        cars.add(new Car("2",0));
        cars.add(new Car("3",0));
        cars.add(new Car("4",0));
        return cars;
    }

    public CompletableFuture<List<Car>> testGetCarList2() {
        return CompletableFuture.supplyAsync(()->testGetCarList());
    }

    public double queryScore(String name) {
        return 1.23+ new Random().nextInt(100);
    }

    public CompletableFuture<Double> queryScore2(String name) {
       return CompletableFuture.supplyAsync(() -> queryScore(name));
    }

}
class Car{
    String name;
    double score;

    public Car(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}