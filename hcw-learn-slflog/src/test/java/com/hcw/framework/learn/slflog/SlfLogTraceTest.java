package com.hcw.framework.learn.slflog;


import com.hcw.framework.learn.log4j.Log4JTrace;
import com.hcw.framework.learn.log4j2.Log4j2Trace;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * slf4j 如何统一日志标准
 *
 *  第一种情况：
 *  A项目 使用 log4j
 *  B项目 使用 log4j2
 *  C项目 使用 logback
 *
 *  那么D 引入 A，B，C项目，是可以运行的。即单独运行是可以的
 *
 *  第二种情况：
 *  A项目 使用log4j - slf4j
 *  B项目 使用log4j2 -slf4j
 *  C项目 使用logback
 *
 *  运行查看日志
 *  SLF4J: Class path contains multiple SLF4J providers.
 * SLF4J: Found provider [org.slf4j.log4j12.Log4j12ServiceProvider@2ed94a8b]
 * SLF4J: Found provider [ch.qos.logback.classic.spi.LogbackServiceProvider@38082d64]
 * SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
 * SLF4J: Actual provider is of type [org.slf4j.log4j12.Log4j12ServiceProvider@2ed94a8b]
 *
 * 红字报错了。并且随机选取一个，logback失效。
 * 如何解决这个问题。可以exclude slf适配器
 *<  <dependency>
 *    <groupId>org.apache.logging.log4j</groupId>
 *         <artifactId>log4j-slf4-impl</artifactId>
 *          <version>99.99.99</version>
 *    </dependency>
 *
 *         <dependency>
 *             <groupId>org.slf4j</groupId>
 *             <artifactId>slf4j-log4j12</artifactId>
 *             <version>99.99.99</version>
 *         </dependency>
 *
 *
 * 第三种情况：
 * A项目 使用log4j
 * B 项目 使用log4j2 - slf4j
 * C 项目 使用logback
 *
 * 看日志
 * [Log4j2Trace.java:15]2020-06-15 22:34:19.760 [INFO] {main} log4j2 is logging
 * 2020-06-15 22:34:19,801 [INFO ] com.hcw.framework.learn.log4j.Log4JTrace: log4j is logging
 * [LogBackTrace.java:11]2020-06-15 22:34:19.802 [INFO] {main} logback is logging
 * 发现A项目使用的log4j日志，那么如何将3个项目统一用slf4j，并且只使用logback配置文件呢
 * 引入了桥接模式的jar
 *  <dependency>
 *             <groupId>log4j</groupId>
 *             <artifactId>log4j</artifactId>
 *             <version>99.99.99</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.slf4j</groupId>
 *             <artifactId>log4j-over-slf4j</artifactId>
 *             <version>2.0.0-alpha1</version>
 *         </dependency>
 *         或者
 *                 <!--  log4j-over-slf4j  log4j 顺序决定了加载那个jar-->
 *         <dependency>
 *             <groupId>org.slf4j</groupId>
 *             <artifactId>log4j-over-slf4j</artifactId>
 *             <version>2.0.0-alpha1</version>
 *         </dependency>
 *
 *         <dependency>
 *             <groupId>log4j</groupId>
 *             <artifactId>log4j</artifactId>
 *             <version>1.2.17</version>
 *         </dependency>
 */
public class SlfLogTraceTest {



    @Test
    public void trace() {
        Logger logger;
        new Log4j2Trace().trace();
        new Log4JTrace().trace();
        new LogBackTrace().trace();
    }
}