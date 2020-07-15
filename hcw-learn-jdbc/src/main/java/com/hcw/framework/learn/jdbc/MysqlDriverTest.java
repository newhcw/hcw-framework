package com.hcw.framework.learn.jdbc;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * mysql driver 原生api开发
 */
public class MysqlDriverTest {


    public static void main(String[] args) {


        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","Root@123");
        try {
            Driver driver = new Driver();
            Connection connection = driver.connect("jdbc:mysql://47.100.240.207:5555/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC", properties);
            Statement statement = connection.createStatement();
            System.out.println("connect success!");
        } catch (SQLException e) {

            System.out.println("connect fail!---"+e.getMessage());
        }

    }
}
