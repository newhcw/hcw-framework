package com.hcw.learn.spring;

import com.hcw.learn.mybatis.SpringBootMybatisApplication;
import com.hcw.learn.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BeanNameAutoProxyCreator代理,实现aop.
 * 底层原理还是实现的beanProcessor
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootMybatisApplication.class })
public class BeanNameAutoProxyCreatorTest {

    @Autowired
    UserService userService;

    @Test
    public void test() throws Exception{
        userService.add();
    }

}
