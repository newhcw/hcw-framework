package com.hcw.learn.jdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Java实现随机写
 */
public class RandomWriter {

    public static void fileWrite(String filePath, String content) {
        FileOutputStream outputStream = null;
        try {
            File file = new File(filePath);
            boolean isCreate = file.createNewFile();//创建文件
            if (isCreate) {
                outputStream = new FileOutputStream(file);//形参里面可追加true参数，表示在原有文件末尾追加信息
                outputStream.write(content.getBytes());
            }else {
                outputStream = new FileOutputStream(file,true);//表示在原有文件末尾追加信息
                outputStream.write(content.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileRead(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                //创建FileInputStream对象，读取文件内容
                FileInputStream fis = new FileInputStream(file);
                byte[] bys = new byte[1024];
                while (fis.read(bys, 0, bys.length) != -1) {
                    //将字节数组转换为字符串
                    System.out.print(new String(bys, StandardCharsets.UTF_8));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        // 模拟WAL
        long curtime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            fileWrite("/Users/huangchunwu/redis-wal.log", "set key value"+i);
        }
        System.out.println("write log cost time is "+(System.currentTimeMillis()-curtime));
    }
}
