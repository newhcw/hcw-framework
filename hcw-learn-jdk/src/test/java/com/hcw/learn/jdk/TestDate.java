package com.hcw.learn.jdk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestDate {


    @Test
    public void test() {
        Assertions.assertEquals(new Date().getHours()>=17 && new Date().getMinutes()>=27,true);
    }
}
