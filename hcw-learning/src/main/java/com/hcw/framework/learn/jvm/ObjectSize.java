package com.hcw.framework.learn.jvm;

import org.apache.lucene.util.RamUsageEstimator;

/**
 *  <dependency>
 *           <groupId>org.apache.lucene</groupId>
 *           <artifactId>lucene-core</artifactId>
 *           <version>4.0.0</version>
 *       </dependency>
 *
 *       一个对象是由对象头 + 对象内容
 *       对象头：地址（4个字节） + 标记（8个字节）+数组（4个字节）+ 对象内容
 */
public class ObjectSize {

    public static void main(String[] args) {
        Integer a = 12;//占据16字节 = 4 + 8 对象头+4个字节int
        System.out.println(RamUsageEstimator.shallowSizeOf(a));
    }
}
