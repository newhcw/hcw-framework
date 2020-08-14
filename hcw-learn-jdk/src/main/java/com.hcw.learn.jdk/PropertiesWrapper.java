package com.hcw.learn.jdk;

import java.io.*;
import java.util.Properties;

/**
 * 保证jdk自带的properties类,解决读取中文乱码
 */
public class PropertiesWrapper {

    private Properties properties = new Properties();

    public Properties load(String path, String charsetName) throws IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(path);
        BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(inputStream, charsetName));
        properties.load(bufferedInputStream);
        return properties;
    }
}
