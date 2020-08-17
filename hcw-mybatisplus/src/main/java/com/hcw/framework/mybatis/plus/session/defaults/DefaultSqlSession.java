package com.hcw.framework.mybatis.plus.session.defaults;

import com.hcw.framework.mybatis.plus.executor.Executor;
import com.hcw.framework.mybatis.plus.executor.SimpleExecutor;
import com.hcw.framework.mybatis.plus.mapping.MappedStatement;
import com.hcw.framework.mybatis.plus.session.Configuration;
import com.hcw.framework.mybatis.plus.session.SqlSession;

import java.util.List;

public class DefaultSqlSession implements SqlSession {

    Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public Object selectone(String statementId, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statementId);
        Executor executor = new SimpleExecutor();
        List<Object> objects = executor.selectList(ms, parameter);
        if (objects == null || objects.size()==0) {
            return null;
        }
        return objects.get(0);
    }

    @Override
    public List<Object> selectList(String statementId, Object parameter) {
        return null;
    }

    @Override
    public Object update(String statementId, Object parameter) {
        return null;
    }

    @Override
    public Object insert(String statementId, Object parameter) {
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type,this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }


}
