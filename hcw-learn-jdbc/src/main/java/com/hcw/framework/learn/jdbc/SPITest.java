package com.hcw.framework.learn.jdbc;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 *  SPI，全称Service Provider Interfaces，服务提供接口。
 *  是Java提供的一套供第三方实现或扩展使用的技术体系。
 *  主要通过解耦服务具体实现以及服务使用，使得程序的可扩展性大大增强，甚至可插拔。
 *  这里的mysqldriver，h2driver，项目如果引入，则使用。 跟主板插上U盘一样
 *
 *  SPI的接口是Java核心库的一部分，是由**启动类加载器(Bootstrap Classloader)来加载的；
 *  PI的实现类是由系统类加载器(System ClassLoader)**来加载的。
 *  引导类加载器是无法找到 SPI 的实现类的，因为依照双亲委派模型，BootstrapClassloader无法委派AppClassLoader来加载类。
 *
 *  SPI具体约定
 * Java SPI的具体约定为：当服务的提供者提供了服务接口的一种实现之后，在jar包的META-INF/services/目录里同时创建一个以服务接口命名的文件。该文件里就是实现该服务接口的具体实现类。而当外部程序装配这个模块的时候，
 * 就能通过该jar包META-INF/services/里的配置文件找到具体的实现类名，并装载实例化，完成模块的注入。
 * 基于这样一个约定就能很好的找到服务接口的实现类，而不需要再代码里制定。
 * jdk提供服务实现查找的一个工具类：java.util.ServiceLoader。
 */
public class SPITest {
    public static void main(String[] args) throws ClassNotFoundException {
        //Class.forName ("com.mysql.cj.jdbc.Driver");
        ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
        Iterator<Driver> driversIterator = loadedDrivers.iterator();
        driversIterator.next();
        driversIterator.forEachRemaining(driver -> {System.out.println(driver+"=="+driver.getClass().getClassLoader());});
    }
}
