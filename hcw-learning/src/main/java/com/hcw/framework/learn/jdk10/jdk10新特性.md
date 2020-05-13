1、局部变量var
2、copyOf方法
    var result = List.copyOf(list);
    在java.util.List、java.util.Set、java.util.Map新增加了一个静态方法copyOf，这些方法按照其迭代顺序返回一个不可修改的列表、集合或映射包含了给定的元素的集合。但是如果将返回后的集合继续修改，那么报异常。
 3、ByteArrayOutputStream
   Java.io.ByteArrayOutputStream，重载toString()方法，通过使用指定的字符集编码字节，将缓冲区的内容转换为字符串，以前是默认没有参数，现在加了一个编码的字符方法。
4、PrintStream、PrintWriter
      Java.io.PrintStream,Java.io.PrintWriter，这两个类都有三个新的构造方法，他们需要而外的参数charset

5、Reader:transferTo方法
Java.io.Reader:transferTo从这个Reader中读取所有字符串，并按照所读取的顺序将字符串写入给指定的Writer

6、Formatter、Scanner
      java.util.Formatter、java.util.Scanner新增三个构造方法，除了其他参数之外，都需要一个charset参数
7、垃圾收集器的优化

    1、JDK9垃圾收集器 ：新生代：ParNew收集器；老年代：Parallel Old收集器   Stop The World

    2、JDK10垃圾收集器：JDK10：G1（Garbage-Frist）全收集器