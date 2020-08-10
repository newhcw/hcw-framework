package com.hcw.framework.learn.jdk8;



/**
 * 验证：
 * 1： 如果没有定义默认无参构造函数，则jvm默认添加。
 * 2:  如果定义了构造函数，则不会赠送无参构造函数
 *
 */
public class ConstructorTest {

    int i,j;

    public ConstructorTest(){
        System.out.println("parent init");
    }



    public static void main(String[] args) {
        new Child();
    }



}

class Child extends ConstructorTest {



    public Child() {
        System.out.println("child init");
    }

}

