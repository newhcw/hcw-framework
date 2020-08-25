package com.hcw.framework.mybatis.plus.builder;

import com.hcw.framework.mybatis.plus.mapping.BoundSql;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StaticSqlSource implements SqlSource{

    private String sql;


    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        BoundSql boundSql = new BoundSql(sql,null,parameterObject);
        return boundSql;
    }
}
