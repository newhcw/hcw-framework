package com.hcw.framework.mybatis.plus.session.defaults;

import com.hcw.framework.mybatis.plus.session.Configuration;
import com.hcw.framework.mybatis.plus.session.SqlSession;
import com.hcw.framework.mybatis.plus.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(this.getConfiguration());
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}