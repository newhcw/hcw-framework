package com.hcw.framework.design.pattern.builder;

import java.util.Map;

import lombok.Builder;

@Builder
public class HttpClient {
    private String url;
    private Method method;
    private Map parameter;


    public static void main(String[] args) {
        HttpClient.builder().url("http://aliserver/api/user/query")
        .method(Method.GET)
        .parameter(Map.of("uuid", "432231", "key", "di2da2ddsa3s"))
        .build();
    }

}

enum Method{
    GET,POST;
}