package com.hcw.learn.jdk;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.BitSet;

/**
 * 布隆过滤器
 * Implementing Bloom filter in Java using Guava Library:
 * <dependency>
 *     <groupId>com.google.guava</groupId>
 *     <artifactId>guava</artifactId>
 *     <version>19.0</version>
 * </dependency>
 */
public class BloomFilterTest {


    /**
     * Bitset一个1G的空间，有 8*1024*1024*1024=8.58*10^9bit，也就是可以表示85亿个不同的数。
     * 第一是当样本分布极度不均匀的时候，BitSet会造成很大空间上的浪费。举个例子，比如你有5个数，分别是1、2、3、4、999，那么这个BitSet至少得有1000位，中间的位置很多就被浪费掉了。
     *
     * 第二是BitSet只面向数字比较，并且还得是正数，其他类型需要先转换成int类型，但是转换过程中难免会出现重复，BitSet的准确性就会降低。
     */
    @Test
    public void testBitSet() {
        BitSet bitSet = new BitSet(10);
        bitSet.set(1);
        bitSet.set(2);
        System.out.println(bitSet.get(1212));
        System.out.println(bitSet.get(1));
    }

    @Test
    public void testBloomFilter() {
        BloomFilter blackListIps = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")),10000);
        blackListIps.put("192.168.2.1");
        blackListIps.put("192.168.2.3");
        blackListIps.put("192.168.3.3");

        System.out.println(blackListIps.mightContain("192.168.2.1"));
        System.out.println(blackListIps.mightContain("192.168.4.1"));

    }
}
