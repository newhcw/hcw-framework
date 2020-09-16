package com.hcw.learn.jdk;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JodaTimeTest {

    @Test
    public void testStrToDate() {
        String date = "2020-01-01";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        System.out.println(localDate);
    }

    @Test
    public void testDateToStr() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = localDate.format(dateTimeFormatter);
        System.out.println(formatDate);
    }

    @Test
    public void testGetNowDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    @Test
    public void testLocalDateToDate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());
        System.out.println(date);
    }

    @Test
    public void testDateToLocalDate() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println(localDate);
    }

    @Test
    public void testTimestampToLocalDateTime() {
        long timestamp = System.currentTimeMillis();
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime);
    }

    @Test
    public void testLocalDateTimeToTimestamp() {
        LocalDateTime localDateTime = LocalDateTime.now();
        long epochMilli1 = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();// 写法 1
        long epochMilli2 = localDateTime.toInstant(ZoneOffset.of("+08:00")).toEpochMilli();// 写法 2
        long epochMilli3 =  localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();// 写法 3
        System.out.println(epochMilli1);
        System.out.println(epochMilli2);
        System.out.println(epochMilli3);

    }

}
