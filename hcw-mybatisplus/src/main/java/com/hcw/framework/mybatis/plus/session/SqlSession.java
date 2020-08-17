package com.hcw.framework.mybatis.plus.session;

import java.util.List;

public interface SqlSession {

    Object selectone(String statementId, Object parameter);

    List<Object> selectList(String statementId, Object parameter);

    Object update(String statementId, Object parameter);

    Object insert(String statementId, Object parameter);

    <T> T getMapper(Class<T> type);
}
