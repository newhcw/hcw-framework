package com.hcw.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
    public static final String URL = "jdbc:mysql://192.168.2.178:3306/test?useUnicode=true&characterEncoding=utf8";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static DbUtil instance = new DbUtil();

    DbUtil() {
        // 1.加载驱动程序
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public static Connection openConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }

    public static ResultSet query(Connection conn,String sql) throws SQLException {
        var stmt = conn.prepareStatement(sql);
        var rs = stmt.executeQuery(sql);
        return rs;
    }

    public static int update(Connection conn,String sql) throws SQLException {
        var stmt = conn.prepareStatement(sql);
        var rs = stmt.executeUpdate();
        return rs;
    }
}