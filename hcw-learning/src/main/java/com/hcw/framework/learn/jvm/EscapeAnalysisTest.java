package com.hcw.framework.learn.jvm;

/**
 * 逃逸分析
 * 开启逃逸分析:-Xmx10m -Xms10m -Xlog:gc -XX:+DoEscapeAnalysis
 * 关闭逃逸分析:-Xmx10m -Xms10m -Xlog:gc -XX:-DoEscapeAnalysis
 */
public class EscapeAnalysisTest {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000000; i++) {
            byte[] b = new byte[2];
        }
    }

}
