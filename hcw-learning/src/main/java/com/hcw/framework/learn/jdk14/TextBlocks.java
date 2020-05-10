package com.hcw.framework.learn.jdk14;

public class TextBlocks {

    public static void main(String[] args) {
       
        //before jdk14
        String multiLineString1 = "first line /br " +
        "second line /br" +
        " third line";

        System.out.println(multiLineString1);

       //jdk14
        String multiLineString2 = """ 
        first 
        second line 
        third line
        """;

        System.out.println(multiLineString2);

    }
    
}