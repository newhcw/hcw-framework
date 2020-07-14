package com.hcw.framework.learn.jdk14;

//这个record关键字的语义，是简化bean，省略掉繁琐的构造函数、equals()、hashCode()、toString()等，如下面这种格式：

public class Records {

    public static void main(String[] args) {

        //after jdk14 
        // 定义
//        record Image(String mediaId){}
//        // 使用
//        Image image = new Image("传mediaId");
//        // 取里面的值
//        System.out.println(image.mediaId());
    }

}