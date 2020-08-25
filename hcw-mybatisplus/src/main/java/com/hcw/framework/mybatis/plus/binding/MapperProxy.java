package com.hcw.framework.mybatis.plus.binding;

import com.hcw.framework.mybatis.plus.mapping.MappedStatement;
import com.hcw.framework.mybatis.plus.mapping.SqlCommandType;
import com.hcw.framework.mybatis.plus.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = className.concat(".").concat(methodName);
        MappedStatement mappedStatement = sqlSession.getConfiguration().getMappedStatement(statementId);
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object result = null;

        switch (sqlCommandType) {
            case SELECT:
                result =  sqlSession.selectone(statementId, args[0]);
                break;
            case UPDATE:
                result = sqlSession.update(statementId, args[0]);
                break;
            default:
                break;
        }
        return result;
    }
}
