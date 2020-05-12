package com.hcw.framework.learn.jdk14;

/**
 * JEP 358增强了对NullPointerException异常的处理，可以显示详细的信息。这个功能需要通过选项-XX:+ShowCodeDetailsInExceptionMessages启用
 */
public class HelpfulNullPointerException {

    public static void main(String[] args) {
        //after jdk14
        String s = null;
        String b = "";
        System.out.println(s.toString() + b.toString());
    }
    

    
}