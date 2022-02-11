package com.hcw.learn.guava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static Long DATE_SUBTRACTION(Date before, Date now){
        try {
            long second = 1000;
            long result = (before.getTime() -now
                    .getTime())/second;
            return result;
        }catch (Exception e){
            return null;
        }
    }

    public static Long DATE_SUBTRACTION2(Date before, Date now){
        SimpleDateFormat d = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String nowTime = d.format(now);
        String beforeTime = d.format(before);
        try {
            long second = 1000;
            long result = (d.parse(nowTime).getTime() - d.parse(beforeTime)
                    .getTime())/second;
            return result;
        }catch (Exception e){
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(DATE_SUBTRACTION(new Date(),new Date("2021-01-01")));
        System.out.println(DATE_SUBTRACTION2(new Date(),new Date("2021-0101")));
    }
}
