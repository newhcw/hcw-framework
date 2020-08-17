package com.hcw.framework.mybatis.plus.transaction.jdbc;

import java.sql.*;
import java.util.List;

public class JdbcRegister {

    private String url = "jdbc:mysql://47.100.240.207:5555/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&generateSimpleParameterMetadata=true";
    private String user = "root";
    private String password = "Root@123";

    private Connection connection;

    public JdbcRegister(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement newPreparedStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }



    public void execute(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.execute();
    }

    public List getResultSet(PreparedStatement preparedStatement, Class target) throws SQLException {
        ResultSet resultSet = preparedStatement.getResultSet();
        ResultSetMetaData resultSetMetaData2 = resultSet.getMetaData();
        int columnCount = resultSetMetaData2.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i < columnCount; i++) {
                System.out.println(resultSetMetaData2.getColumnName(i) + ":" + resultSet.getObject(i));
            }
        }
        return null;
    }

}
