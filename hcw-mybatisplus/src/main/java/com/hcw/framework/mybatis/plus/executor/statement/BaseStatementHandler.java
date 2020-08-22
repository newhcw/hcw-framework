package com.hcw.framework.mybatis.plus.executor.statement;

import com.hcw.framework.mybatis.plus.builder.SqlSource;
import com.hcw.framework.mybatis.plus.builder.SqlSourceBuilder;
import com.hcw.framework.mybatis.plus.mapping.MappedStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseStatementHandler implements StatementHandler{


    @Override
    public Statement prepare(Connection connection, MappedStatement mappedStatement) throws SQLException {
        List paramterList = new ArrayList();
        SqlSource sqlSource = new SqlSourceBuilder().parse(mappedStatement.getSqlSource().getSql(),"#{","}",paramterList);
        mappedStatement.setSqlSource(sqlSource);
        return connection.prepareStatement(sqlSource.getSql());
    }

    @Override
    public <E> List<E> query(Statement statement) throws SQLException {
        PreparedStatement ps = (PreparedStatement) statement;
        // 交给paramterHandler处理参数set
        ps.execute();
        System.out.println(ps.getResultSet());
        return getResultSet(ps,Object.class);
    }
    public List getResultSet(PreparedStatement preparedStatement, Class target) throws SQLException {
        List result = new ArrayList();
        ResultSet resultSet = preparedStatement.getResultSet();
        ResultSetMetaData resultSetMetaData2 = resultSet.getMetaData();
        int columnCount = resultSetMetaData2.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i < columnCount; i++) {
                System.out.println(resultSetMetaData2.getColumnName(i) + ":" + resultSet.getObject(i));
                result.add(resultSetMetaData2);
            }
        }
        return result;
    }
}
