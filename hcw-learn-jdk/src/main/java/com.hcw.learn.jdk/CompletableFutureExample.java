package com.hcw.learn.jdk;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 多渠道查询出发站-到达站
 * 1. 从12306
 * 2. 从ctrip 查询出发站-到达站
 * 3. 从同城查询
 *
 * 获取站站对，再去余票接口查询余票。
 * 1. 从12306
 * 2. 从ctrip 查询出发站-到达站
 * 3. 从同城查询
 */
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cfCtripQuery = CompletableFuture.supplyAsync(()-> queryTripStation("http://ctrip/train/station/query"));
        CompletableFuture<String> cf12306Query = CompletableFuture.supplyAsync(()-> queryTripStation("http://12306/train/station/query"));
        CompletableFuture<String> cfTCQuery = CompletableFuture.supplyAsync(()-> queryTripStation("http://tongchen/train/station/query"));

        CompletableFuture<Object> stationFuture = CompletableFuture.anyOf(cf12306Query, cfCtripQuery, cfTCQuery);

        CompletableFuture<Object> ctripPrice = stationFuture.thenApplyAsync(v -> {
           return queryTicketNum(v.toString(), "ctrip");
        });
        CompletableFuture<Object> ctrip12306Price = stationFuture.thenApplyAsync(v -> {
            return queryTicketNum(v.toString(), "12306");
        });

        CompletableFuture<Object> ctriptongchengPrice = stationFuture.thenApplyAsync(v -> {
            return queryTicketNum(v.toString(), "tongcheng");
        });

        CompletableFuture<Object> priceFuture = CompletableFuture.anyOf(ctripPrice, ctrip12306Price, ctriptongchengPrice);

        priceFuture.thenAccept(v-> System.out.println(v));
        Thread.sleep(1000*30);
    }

    private static String queryTripStation(String url)  {
        System.out.println("开始查询站站对"+url);
        try {
            Thread.sleep(1000* new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束查询站站对"+url);
        return "COD@";
    }

    private static Double queryTicketNum(String station,String url) {
        System.out.println("开始查询余票:"+station);
        try {
            Thread.sleep(1000*new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束查询余票"+station);
        return 102.45;
    }
}
