package com.hcw.learn.jdk;

import org.junit.jupiter.api.Test;

public class TryCatchTest {


    @Test
    public void testCatchReturn() {
        for (int i = 0; i < 11; i++) {
            try {
                System.out.println(i);
                Integer.valueOf("1.01");
                return;// 函数结束
            } catch (Exception e) {
                return; // 函数结束
            }
        }
    }

}
