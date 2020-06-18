package com.hcw.framework.learn.jvm;

public class HexConv {


    public static String hexChangeBinary(Integer tenHex){
        return Integer.toBinaryString(tenHex);
    }

    public static void main(String[] args) {
       System.out.println(hexChangeBinary(11));
    }
}
