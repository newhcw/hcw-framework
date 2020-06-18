package com.hcw.framework.learn.jvm;

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
        byte aByte  = UnsafeTool.getUnsafe().getByte(new Object(),0);
        System.out.println( HexConv.hexChangeBinary(Integer.valueOf(aByte)));
        int objectcode = System.identityHashCode(o);
        System.out.println(HexConv.hexChangeBinary(Integer.valueOf(objectcode)));
    }
}
