package com.hcw.framework.mybatis.plus.session;

public interface SqlSessionFactory {

    public SqlSession openSession();

    public Configuration getConfiguration();
}
