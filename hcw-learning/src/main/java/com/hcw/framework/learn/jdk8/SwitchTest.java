package com.hcw.framework.learn.jdk8;

public class SwitchTest {
    /**
     * 这里会打印 17,18
     * @param args
     */
    public static void main(String[] args) {
        String key = "17";
        switch (key){
            case "16":
                System.out.println("16");
            case "17":
                System.out.println("17");
            case "18":
                System.out.println("18");
            default:
                System.out.println("default");
        }
    }
}
