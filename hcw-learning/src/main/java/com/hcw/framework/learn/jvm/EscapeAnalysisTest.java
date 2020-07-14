package com.hcw.framework.learn.jvm;

/**
 * 逃逸分析
 * 开启逃逸分析:-Xmx10m -Xms10m -Xlog:gc -XX:+DoEscapeAnalysis
 * 关闭逃逸分析:-Xmx10m -Xms10m -Xlog:gc -XX:-DoEscapeAnalysis
 */
public class EscapeAnalysisTest {

    public static void main(String[] args) {
        long curtime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            byte[] b = new byte[2];
        }
        System.out.println((System.currentTimeMillis()-curtime) + "ms");
    }

}
