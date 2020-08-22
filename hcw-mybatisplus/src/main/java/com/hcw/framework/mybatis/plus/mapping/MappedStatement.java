package com.hcw.framework.mybatis.plus.mapping;

import com.hcw.framework.mybatis.plus.builder.SqlSource;
import lombok.Data;

@Data
public class MappedStatement {

    private String id;
    private SqlCommandType sqlCommandType;
    private SqlSource sqlSource;

}
