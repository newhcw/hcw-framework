package com.hcw.framework.learn.jdbc;


import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * jdbc开发:
 * 1: SPI
 * 2: 破坏双亲委托
 *
 * SPI，全称Service Provider Interfaces，服务提供接口。
 * 是Java提供的一套供第三方实现或扩展使用的技术体系。
 * 主要通过解耦服务具体实现以及服务使用，使得程序的可扩展性大大增强，甚至可插拔。
 */
public class JdbcTest {

    public static void main(String[] args) {
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");

            DriverManager.getConnection("jdbc:mysql://47.100.240.207:5555/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","Root@123");
            System.out.println("connect success");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("connect fail");
        }

    }
}
