package com.hcw.learn.jdk;

import org.junit.jupiter.api.Test;

/**
 * 为什么局部内部类和匿名内部类只能访问局部final变量？
 * 1 外部类的方法执行完了，匿名内部类拿不到这个值了，Java是采用值拷贝的方式保留的。
 * 2 如果外部类在拷贝之后改变了值，那么这个拷贝的值就出现不一致了。
 */
public class FinalTest {


    /**
     * 基本变量
     * Java是值传递。相当于拷贝一个变量值。不影响方法外的值。所以可以传final修饰的参数
     */
    @Test
    public void testFinalBaseVari() {
        final int i = 0;
        changeValue(i);
        System.out.println(i);
    }

    public void changeValue(int v) {
        v = 10;
    }

    @Test
    public void testFinalWrapperBar() {
        String s = "a";
        changeValue2(s);
        System.out.println(s);
    }

    private void changeValue2(String s) {
        s = "abc";
    }

    /**
     * Java值传递，引用作为形参，相当于复制一个引用地址，方法内部改变的是形参的地址，而不影响方法外的引用。
     * 形参的地址其实也是指向“a”这个地址。所以可以直接改变内存。
     * 总结,final修饰对象引用，可以改变内存值。
     */
    @Test
    public void testFinalObject() {
        StringBuffer sb = new StringBuffer("a");
        changeValue3(sb);
        System.out.println(sb);
    }

    private void changeValue3(StringBuffer sb) {
        sb.append("1221");
        sb = new StringBuffer("dasdaad");
    }
}
