# java8 时间工具使用

简介：JDK8的主要新特性四个：Lambda、Stream、Date、新注解，前两者主要用于集合中。


## 1、获取当前时间

Instant instant = Instant.now(); //获取当前时间戳

LocalDate localDate = LocalDate.now();  //获取当前日期

LocalTime localTime = LocalTime.now();  //获取当前时刻

LocalDateTime localDateTime = LocalDateTime.now();  //获取当前具体时间

ZonedDateTime zonedDateTime = ZonedDateTime.now();   //获取带有时区的时间

## 2、字符串转换时间
jdk8：
String str = "2019-01-11";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate localDate = LocalDate.parse(str, formatter);

jdk7:
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
try {
    Date date = simpleDateFormat.parse(str); 
} catch (ParseException e){ 
    e.printStackTrace();
}

## 3、时间格式化成字符串
LocalDate localDate = LocalDate.now();
DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String formatDate = localDate.format(dateTimeFormatter);
System.out.println(formatDate);


## 4、Date转换LocalDate

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("Date = " + date);
        System.out.println("LocalDate = " + localDate);
    }
}

## 5、LocalDate转Date

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());

        System.out.println("LocalDate = " + localDate);
        System.out.println("Date = " + date);

    }
}

## 6、时间戳转LocalDateTime
long timestamp = System.currentTimeMillis();

Instant instant = Instant.ofEpochMilli(timestamp);

LocalDateTime.ofInstant(instant, ZoneId.systemDefault());



## 7、LocalDateTime转时间戳
LocalDateTime dateTime = LocalDateTime.now();

dateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();

dateTime.toInstant(ZoneOffset.of("+08:00")).toEpochMilli();

dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();