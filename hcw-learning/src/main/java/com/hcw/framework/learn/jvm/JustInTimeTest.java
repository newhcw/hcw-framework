package com.hcw.framework.learn.jvm;

/**
 * -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
 * -XX:+PrintCompilation
 * 即时编译
 * -XX:+PrintInlining
 * 要求虚拟机输出方法内联信息
 */
public class JustInTimeTest {

    public static void main(String[] args) {
        for (; ; ) {
            JustInTimeTest.test();
        }
    }


    public static int  test() {
        int i = 1;
        int j =2;
        return i+j;
    }

}
