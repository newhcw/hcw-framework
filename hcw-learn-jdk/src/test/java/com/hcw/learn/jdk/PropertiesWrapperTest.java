package com.hcw.learn.jdk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

class PropertiesWrapperTest {

    private final String path = "test.properties";


    /**
     * 有乱码问题
     * @throws IOException
     */
    @Test
    public void testOrigin() throws IOException {
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream(path));
        Assertions.assertEquals("hcw-learn-jdk",properties.getProperty("project.name"));
        Assertions.assertEquals("哈罗",properties.getProperty("please.say.hello"));
    }

    @Test
    public void testWrapper() throws IOException {
        PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
        Properties properties = propertiesWrapper.load(path, "GBK");
        Assertions.assertEquals("hcw-learn-jdk",properties.getProperty("project.name"));
        Assertions.assertEquals("哈罗",properties.getProperty("please.say.hello"));
    }
}