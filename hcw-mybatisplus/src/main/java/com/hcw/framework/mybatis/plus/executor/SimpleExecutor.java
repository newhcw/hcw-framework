package com.hcw.framework.mybatis.plus.executor;

import com.hcw.framework.mybatis.plus.executor.statement.PrepareStatementHandler;
import com.hcw.framework.mybatis.plus.executor.statement.StatementHandler;
import com.hcw.framework.mybatis.plus.mapping.MappedStatement;
import com.hcw.framework.mybatis.plus.transaction.Transaction;
import com.hcw.framework.mybatis.plus.transaction.jdbc.JdbcTransaction;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SimpleExecutor extends BaseExecutor{
    @Override
    public Object selectone(MappedStatement ms, Object parameter) {
        return null;
    }

    @Override
    public List<Object> selectList(MappedStatement ms, Object parameter) {
        StatementHandler statementHandler = new PrepareStatementHandler();
        Transaction transaction = new JdbcTransaction();
        Statement statement;

        try {
            statement = statementHandler.prepare(transaction.getConnection(), ms);
            return statementHandler.query(statement,ms);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       return null;
    }


    @Override
    public Object update(MappedStatement ms, Object parameter) {
        return null;
    }

    @Override
    public Object insert(MappedStatement ms, Object parameter) {
        return null;
    }
}
