package com.hcw.framework.mybatis.plus.executor.statement;

import com.hcw.framework.mybatis.plus.mapping.MappedStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface StatementHandler {

    Statement prepare(Connection connection, MappedStatement mappedStatement)
            throws SQLException;

    <E> List<E> query(Statement statement,MappedStatement ms)
            throws SQLException;
}
