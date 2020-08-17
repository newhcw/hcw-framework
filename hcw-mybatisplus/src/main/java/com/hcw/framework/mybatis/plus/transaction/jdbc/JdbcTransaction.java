package com.hcw.framework.mybatis.plus.transaction.jdbc;

import com.hcw.framework.mybatis.plus.session.Configuration;
import com.hcw.framework.mybatis.plus.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTransaction implements Transaction {

    JdbcRegister jdbcRegister = new JdbcRegister(Configuration.url,Configuration.user,Configuration.password);

    @Override
    public Connection getConnection() throws SQLException {
        return jdbcRegister.getConnection();
    }
}
