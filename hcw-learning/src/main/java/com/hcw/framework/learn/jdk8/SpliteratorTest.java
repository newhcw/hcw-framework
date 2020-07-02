package com.hcw.framework.learn.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * iterator 流式迭代器
 * 可以支持list 并发迭代执行
 *
 * int characteristics() Characteristics int characteristics() ：返回分隔符的特征列表。 它可以是ORDERED，DISTINCT，SORTED，SIZED，NONNULL，IMMUTABLE，CONCURRENT和SUBSIZED中的任何一个。
 * long estimateSize() EstimateSize long estimateSize() ：返回对forEachRemaining（）遍历将遇到的元素数量的估计，如果无限，未知或计算成本太高，则返回Long.MAX_VALUE。
 * 默认void forEachRemaining（Consumer action） ：在当前线程中按顺序对每个剩余元素执行给定操作，直到所有元素都已处理或该操作引发异常。
 * default Comparator getComparator() ：如果分隔符的源由Comparator排序，则返回该Comparator。
 * default long getExactSizeIfKnown() ：如果此分隔符为SIZED，则返回estimateSize（），否则为-1。
 * 默认布尔值hasCharacteristics（int features） ：如果dpliterator的features（）包含所有给定的特性，则返回true。
 * boolean tryAdvance(Consumer action) ：如果存在剩余元素，则对它执行给定的操作，返回true ；否则返回true 。 否则返回false 。
 * Spliterator trySplit() ：如果可以对分隔器进行分区，则返回一个覆盖元素的Spliterator，当从该方法返回时，该元素将不被此Spliterator覆盖
 */
public class SpliteratorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","4","2","3");
        Spliterator<String> spliterator1 = list.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        spliterator1.forEachRemaining(System.out::println);
        System.out.println("------------------");
        spliterator2.forEachRemaining(System.out::println);
    }
}
