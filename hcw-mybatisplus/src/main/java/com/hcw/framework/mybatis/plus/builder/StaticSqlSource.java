package com.hcw.framework.mybatis.plus.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StaticSqlSource implements SqlSource{

    private String sql;

}
