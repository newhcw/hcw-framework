package com.hcw.framework.learn.jvm;

/**
 * -XX:MetaspaceSize=3m  设置这个参数才会触发GC,如果不设置的话，默认是20.79M
 * -XX:MaxMetaspaceSize=100m 设置最大的metaspace空间
 * -XX:+PrintGCDetails 打开GC日志
 * -XX:MinMetaspaceFreeRatio：最小空闲比，当 Metaspace 发生 GC 后，会计算 Metaspace 的空闲比，如果空闲比(空闲空间/当前 Metaspace 大小)小于此值，就会触发 Metaspace 扩容。默认值是 40 ，也就是 40%，例如 -XX:MinMetaspaceFreeRatio=40
 * -XX:MaxMetaspaceFreeRatio:最大空闲比，当 Metaspace 发生 GC 后，会计算 Metaspace 的空闲比，如果空闲比(空闲空间/当前 Metaspace 大小)大于此值，就会触发 Metaspace 释放空间。默认值是 70 ，也就是 70%，例如 -XX:MaxMetaspaceFreeRatio=70
 * -XX:+PrintCommandLineFlags -XX:+PrintFlagsInitial 打印默认启动参数
 */
public class MetaSpace {

    public static void main(String[] args) throws ClassNotFoundException {

        while (true){
            Class.forName("com.hcw.framework.learn.ddd.domain.Customer");
        }
    }
}
