package com.hcw.framework.learn.jdk14;

import com.blade.Blade;

public class Bladejava {
    
    public static void main(String[] args) {
        Blade.of().get("/", ctx -> ctx.text("Hello Blade")).start();
    }
}