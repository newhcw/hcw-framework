package com.hcw.learn.jvm.oom;

/**
 * 操作系统局部性原理
 */
public class PartialPrinciple {

    public static void main(String[] args) {
        int[][] array = new int[10000][10000];

        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j <10000 ; j++) {
                array[i][j]=i*j;
            }
        }

        long begein = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                int i1 = array[i][j];
            }
        }
        long diff = System.currentTimeMillis()-begein;
        System.out.println("顺序访问："+diff);


        begein = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                int i1 = array[j][i];
            }
        }
        diff = System.currentTimeMillis()-begein;
        System.out.println("跨行访问："+diff);
    }
}
