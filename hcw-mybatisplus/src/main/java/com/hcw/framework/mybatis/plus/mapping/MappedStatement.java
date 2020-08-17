package com.hcw.framework.mybatis.plus.mapping;

import lombok.Data;

@Data
public class MappedStatement {

    private String id;
    private String sql;
    private SqlCommandType sqlCommandType;

}
