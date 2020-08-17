package com.hcw.framework.mybatis.plus.transaction;

import java.sql.Connection;
import java.sql.SQLException;

public interface Transaction {

    Connection getConnection() throws SQLException;
}
