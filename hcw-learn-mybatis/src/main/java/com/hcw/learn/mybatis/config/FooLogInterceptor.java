package com.hcw.learn.mybatis.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class FooLogInterceptor implements MethodInterceptor {

    Logger logger = LoggerFactory.getLogger(FooLogInterceptor.class);


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();

        Object result = null;
        try {
            result = invocation.proceed();
            return result;
        } catch (Exception e) {
            throw e;
        } finally {

            try {
                // do log
                logger.info("invoke result:{}",result);
            } catch (Exception e) {
                // todo
            }
        }
    }


}
