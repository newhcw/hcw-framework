package com.hcw.framework.mybatis.plus.executor;

import com.hcw.framework.mybatis.plus.mapping.MappedStatement;

import java.util.List;

public interface Executor {

    Object selectone(MappedStatement ms, Object parameter);

    List<Object> selectList(MappedStatement ms, Object parameter);

    Object update(MappedStatement ms, Object parameter);

    Object insert(MappedStatement ms, Object parameter);
}
