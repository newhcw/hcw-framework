package com.hcw.framework.mybatis.plus.executor.parameter;

import com.hcw.framework.mybatis.plus.mapping.JdbcType;
import com.hcw.framework.mybatis.plus.mapping.MappedStatement;
import com.hcw.framework.mybatis.plus.mapping.ParameterMapping;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DefaultParameterHandler implements ParameterHandler{

    @Override
    public void setParameters(PreparedStatement ps) throws SQLException {

    }

    @Override
    public void parameterize(Statement statement, MappedStatement mt) throws SQLException {
        PreparedStatement p = (PreparedStatement) statement;
        List<ParameterMapping> parameterMappings = mt.getSqlSource().getBoundSql(null).getParameterMappings();
        for (ParameterMapping parameterMapping : parameterMappings) {
            if (parameterMapping.getJdbcType() == JdbcType.INTEGER) {
                p.setInt(1,1);
            }
        }
        p.setObject(1,"");
    }
}
