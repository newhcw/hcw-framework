package com.hcw.framework.mybatis.plus.executor.parameter;

import com.hcw.framework.mybatis.plus.mapping.MappedStatement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface ParameterHandler {

    void setParameters(PreparedStatement ps)
            throws SQLException;

    void parameterize(Statement statement, MappedStatement mt) throws SQLException;

}
