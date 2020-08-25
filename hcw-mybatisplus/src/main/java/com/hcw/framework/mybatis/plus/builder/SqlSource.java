package com.hcw.framework.mybatis.plus.builder;

import com.hcw.framework.mybatis.plus.mapping.BoundSql;

public interface SqlSource {
    BoundSql getBoundSql(Object parameterObject);
}
