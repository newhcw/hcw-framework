package com.hcw.framework.design.pattern.decorator;

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

    public static void main(String[] args)  {
        Decorator decoratorMysql = new ConcreateDecorator(new MysqlComponent());
        decoratorMysql.queryList();

        Decorator decoratorRedis = new ConcreateDecorator(new RedisComponent());
        decoratorRedis.queryList();
    }
}