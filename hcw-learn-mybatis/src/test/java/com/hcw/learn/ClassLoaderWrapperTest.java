package com.hcw.learn;

import org.junit.Test;

import java.net.URL;

public class ClassLoaderWrapperTest {

    @Test
    public void test() {
        URL classLoaderWrapper = ClassLoader.getSystemResource("ClassLoaderWrapper");
        System.out.println(classLoaderWrapper);
    }


}
