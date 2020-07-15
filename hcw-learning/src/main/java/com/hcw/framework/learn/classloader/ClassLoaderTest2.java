package com.hcw.framework.learn.classloader;

/**
 * 这里注意2点:
 * 1 findClass 的作用不是按照双亲加载class,loadClass才会按照双亲委派机制
 * 2 这个例子验证了双亲委派机制的存在.
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) {

        try {
            MyClassLoader myClassLoader = new MyClassLoader(ClassLoaderTest2.class.getClassLoader(),"load1","D:\\Order.class");
            MyClassLoader myClassLoader2 = new MyClassLoader(null,"load2","D:\\Order.class");

            // AppClassLoader加载
            Class orderClass = Class.forName("com.hcw.framework.learn.ddd.domain.Order");
            orderClass.newInstance();
            // MyClassLoader1 加载
            Class orderClass1 = myClassLoader.loadClass("com.hcw.framework.learn.ddd.domain.Order");
            orderClass1.newInstance();
            // MyClassLoader2 加载
            Class orderClass2 = myClassLoader2.loadClass("com.hcw.framework.learn.ddd.domain.Order");
            orderClass2.newInstance();
            myClassLoader2.loadClass("com.hcw.framework.learn.ddd.domain.Product").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
