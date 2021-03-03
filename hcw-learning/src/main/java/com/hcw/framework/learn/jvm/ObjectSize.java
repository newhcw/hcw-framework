package com.hcw.framework.learn.jvm;

import org.apache.lucene.util.RamUsageEstimator;
import org.openjdk.jol.info.ClassLayout;

/**
 *  <dependency>
 *           <groupId>org.apache.lucene</groupId>
 *           <artifactId>lucene-core</artifactId>
 *           <version>4.0.0</version>
 *       </dependency>
 *       或者
 *        <dependency>
 *           <groupId>org.openjdk.jol</groupId>
 *           <artifactId>jol-core</artifactId>
 *           <version>0.9</version>
 *       </dependency>
 *
 *       一个对象是由对象头 + 对象内容 + padding
 *       对象头：
 *       1.地址（开启指针压缩-XX:+UseCompressedOops，4个字节，否则8个字节）
 *       2. markword（64位 8个字节，32位是4个字节）
 *       3. 数组（4个字节）

 */
public class ObjectSize {

    public static void main(String[] args) {
        Integer a = 12;//占据16字节 = 8 + 8 对象头+4个字节int
        System.out.println(RamUsageEstimator.shallowSizeOf(a));
        Object o = new Object();
        System.out.println(RamUsageEstimator.shallowSizeOf(o));
        System.out.println(ClassLayout.parseInstance(o).toPrintable());


    }
}
