package com.hcw.framework.learn.jdk8;


/**
 * Java 1.7中新增的try-with-resource语法糖来打开资源，而无需码农们自己书写资源来关闭代码
 * 为了能够配合try-with-resource，资源必须实现AutoClosable接口。该接口的实现类需要重写close方法：
 */
public class TryWithResource {

    public static void main(final String[] args) {
        TryWithResource t = new TryWithResource();
        try (TestResource resource = t.new TestResource()) {
            resource.print();
        }
    }
    
    class TestResource implements AutoCloseable{

        @Override
        public void close()  {
            

        }

        public void print(){
            System.out.println("a test");
        }

    }

}