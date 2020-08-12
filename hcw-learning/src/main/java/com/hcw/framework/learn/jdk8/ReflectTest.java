package com.hcw.framework.learn.jdk8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class A{
    public A(){
        System.out.println("a");
    }

    public A(int i) {
        System.out.println("a(i)");
    }

    public A(int i,int j) {
        System.out.println("a(i,j)");
    }
}

public class ReflectTest {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor<?>[] constructors = A.class.getConstructors();// 获取所有public的构造函数，如何A前面不声明public，则默认是protect，这里获取不到
//        for (int i = 0; i < constructors.length; i++) {
//            System.out.println(constructors[i]);
//            for (int j = 0; j < constructors[i].getParameterTypes().length; j++) {
//                System.out.println(constructors[i].getParameterTypes()[j]);
//            }
//        }

        for (int i = 0; i < constructors.length; i++) {
            if (constructors[i].getParameterCount()==0){
                constructors[i].newInstance();
            }
            if (constructors[i].getParameterCount()==1){
                constructors[i].newInstance(1);
            }

            if (constructors[i].getParameterCount()==2){
                constructors[i].newInstance(1,2);
            }
        }
    }
}
