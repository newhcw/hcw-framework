package com.hcw.framework.design.pattern.decorator;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 从数据来源或者说是操作对象角度看，IO 类可以分为：

1、文件（file）：FileInputStream、FileOutputStream、FileReader、FileWriter
2、数组（[]）：

2.1、字节数组（byte[]）：ByteArrayInputStream、ByteArrayOutputStream
2.2、字符数组（char[]）：CharArrayReader、CharArrayWriter


3、管道操作：PipedInputStream、PipedOutputStream、PipedReader、PipedWriter
4、基本数据类型：DataInputStream、DataOutputStream
5、缓冲操作：BufferedInputStream、BufferedOutputStream、BufferedReader、BufferedWriter
6、打印：PrintStream、PrintWriter
7、对象序列化反序列化：ObjectInputStream、ObjectOutputStream
8、转换：InputStreamReader、OutputStreWriter
9、字符串（String）Java8中已废弃：StringBufferInputStream、StringBufferOutputStream、StringReader、StringWriter
 */
public class DecoratorTest {

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