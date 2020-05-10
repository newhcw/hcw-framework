package com.hcw.framework.learn.jdk14;

public class PatternMatchingForInstanceOf {

    public static void main(String[] args) {
        //before jdk14
        Object obj = "test";
        if(obj instanceof String){
            String str = (String)obj;
            System.out.println(str);
        }

        //after jdk14
        if(obj instanceof String str2){
            System.out.println(str2);
        }

    }
    
}