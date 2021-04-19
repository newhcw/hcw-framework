package com.hcw.framework.learn.fastjson;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class FastJsonTest {

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new Date()));//这里有坑，默认是date 转成时间戳。
    }
}
