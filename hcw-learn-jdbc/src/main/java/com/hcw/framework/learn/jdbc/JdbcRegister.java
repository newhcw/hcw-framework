package com.hcw.framework.learn.jdbc;

import java.sql.*;

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


    public static void main(String[] args) throws ClassNotFoundException {


//mysql驱动默认generateSimpleParameterMetadata=false
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://47.100.240.207:5555/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&generateSimpleParameterMetadata=true", "root", "Root@123")) {
            String sql = "select * from t_course where id = ? and user_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 1);
            preparedStatement.setObject(2, 1);
            preparedStatement.execute();
            ResultSetMetaData resultSetMetaData1 = preparedStatement.getMetaData();
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();

            int parameterCount = parameterMetaData.getParameterCount();
            for (int i = 0; i < parameterCount; i++) {
                System.out.println(parameterMetaData.getParameterClassName(i + 1));
                System.out.println(parameterMetaData.getParameterTypeName(i + 1));
                System.out.println(parameterMetaData.getParameterMode(i + 1));
            }

            ResultSet resultSet = preparedStatement.getResultSet();
            ResultSetMetaData resultSetMetaData2 = resultSet.getMetaData();
            int columnCount = resultSetMetaData2.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i < columnCount; i++) {
                    System.out.println(resultSetMetaData2.getColumnName(i) + ":" + resultSet.getObject(i));
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public PreparedStatement newPreparedStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void setParameter(PreparedStatement preparedStatement,Object parameter) throws SQLException {
        MetaClass meta = new MetaClass(parameter.getClass());
        int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
        for (int i = 0; i < parameterCount; i++) {
            preparedStatement.setObject(i+1,null);
        }
    }

    public void execute(){

    }

}
