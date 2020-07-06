package com.hcw.learn.mybatis.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanNameAutoProxyCreatorConfiguration {

    Logger logger = LoggerFactory.getLogger(BeanNameAutoProxyCreatorConfiguration.class);

    @Bean
    public BeanNameAutoProxyCreator newBeanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("*Service");
        beanNameAutoProxyCreator.setInterceptorNames("fooLogInterceptor");
        return beanNameAutoProxyCreator;
    }

    //创建Advice或Advisor
    @Bean
    public FooLogInterceptor fooLogInterceptor(){
        return new FooLogInterceptor();
    }

}
