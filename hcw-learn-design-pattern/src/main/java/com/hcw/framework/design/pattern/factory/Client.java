package com.hcw.framework.design.pattern.factory;

import com.hcw.framework.design.pattern.entity.Pizza;

import java.io.*;

/**
 * 工厂模式,屏蔽产品实现细节,符合迪米特原则,高层只知道产品的抽象,符合依赖倒置原则,
 * 新增产品类,只需要扩展工厂,符合开闭原则
 * 使用产品子类替换父类,没用问题,符合里氏替换
 */
public class Client {

    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new SimpleBeanFactory();
        Pizza pizza = (Pizza) beanFactory.getBean("com.hcw.framework.design.pattern.entity.Pizza");
        System.out.println(pizza);

        // 原生版 io操作 BufferedReader
        InputStream inputStream = System.in;//读取字节流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//将字节流向字符流的转换。
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //创建字符流缓冲区
        String line;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        //工厂模式改进 BufferedReader
        BufferedReaderFactory readerFactory =  new BufferedReaderFactory();
        BufferedReader bufferedReader1 = readerFactory.getReader(System.in);
        while((line = bufferedReader1.readLine())!=null){
            System.out.println(line);
        }

        // 换成InputStreamReader,只需要添加一个工厂
        InputStreamReaderFactory inputStreamReaderFactory =  new InputStreamReaderFactory();
        InputStreamReader inputStreamReader1 = inputStreamReaderFactory.getReader(System.in);
        while((line = (char)inputStreamReader1.read()+"")!=null){
            System.out.println(line);
        }

    }
    
}