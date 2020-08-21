package com.hcw.framework.mybatis.plus.builder;

import lombok.Data;

@Data
public class StaticSqlSource implements SqlSource{

    private String sql;
}
