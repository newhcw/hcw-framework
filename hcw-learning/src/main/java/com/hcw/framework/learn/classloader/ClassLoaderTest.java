package com.hcw.framework.learn.classloader;

import com.hcw.framework.learn.ddd.domain.Order;

/**
 * 这个例子验证类加载的过程
 * 加载 --- 连接 -- 类初始化
 * 实例初始化
 * 构造方法--实例变量
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader(null,"load1","D:\\Order.class");
        try {
            //程序运行时，类型的加载，连接，初始化，是在程序运行期完成的。
            //开启类加载跟踪 -XX:+TraceClassLoading,发现,这句话执行了,类加载器加载com.hcw.framework.learn.ddd.domain.Order
            Class orderClass = myClassLoader.loadClass("com.hcw.framework.learn.ddd.domain.Order");
            orderClass.newInstance();
            // 执行下面,才会触发连接初始化,执行静态方法块
            Class orderClass2 =  Class.forName("com.hcw.framework.learn.ddd.domain.Order");
            //执行下面,会触发构造函数执行
            orderClass2.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
