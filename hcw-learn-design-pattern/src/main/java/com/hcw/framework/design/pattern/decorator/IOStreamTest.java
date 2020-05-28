package com.hcw.framework.design.pattern.decorator;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOStreamTest {
    

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/huangchunwu/Downloads/dd.js"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/huangchunwu/Downloads/dd2.js"));
        fileInputStream.transferTo(fileOutputStream);

        byte[] bytes = new byte[1024];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayInputStream.transferTo(byteArrayOutputStream);



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符");
        char c;
        c = (char) bufferedReader.read();
        System.out.println("你输入的字符为"+c);
    }
}