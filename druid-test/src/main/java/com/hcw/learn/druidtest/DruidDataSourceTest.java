package com.hcw.learn.druidtest;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidDataSourceTest {

    public static DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        //dbhost=jdbc:mysql://172.18.23.100:3306/yourdatabase?useUnicode=yes&characterEncoding=UTF-8&useSSL=false
        dataSource.setUrl("jdbc:mysql://node1:3306/test?useSSL=false&characterEncoding=utf8&serverTimezone=UTC&connectTimeout=1200&socketTimeout=3000");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        //dataSource.setInitialSize(20);
       // dataSource.setMaxActive(20);
        return dataSource;
    }

    public static void main(String[] args) throws SQLException {

        DataSource dataSource = getDataSource();
        try(Connection connection = dataSource.getConnection()){
            ResultSet resultSet = connection.createStatement().executeQuery("select * from user ");
            while (resultSet.next()) {
                System.out.println(resultSet.toString());
            }
        }
    }
}
