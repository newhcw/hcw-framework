package com.hcw.framework.mybatis.plus.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ParameterHandler {

    void setParameters(PreparedStatement ps)
            throws SQLException;
}
