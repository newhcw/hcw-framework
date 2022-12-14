package com.hcw.framework.learn.jvm;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTool {

    public static Unsafe getUnsafe() throws Exception {
        Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
        Field field = unsafeClass.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return  (Unsafe) field.get(null);
    }

    public static void main(String[] args) throws Exception {
        Object o = new Object();
        byte aByte  = UnsafeTool.getUnsafe().getByte(new Object(),0);//对象头,这里为什么偏移量是0,怎么查看偏移量看printObject
        System.out.println( HexConv.hexChangeBinary(Integer.valueOf(aByte)));

        printObject();
    }

    public  static void printObject(){
        //System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
    }

}
