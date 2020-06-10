package com.hcw.learn.mybatis;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootMybatisApplication.class })
public class DataSourcePoolTest {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    Configuration configuration;
    JdbcTransaction jdbcTransaction;

    MappedStatement mappedStatement;

    @Before
    public void before() throws FileNotFoundException {
        configuration = sqlSessionFactory.getConfiguration();
        jdbcTransaction = new JdbcTransaction(sqlSessionFactory.openSession().getConnection());
        mappedStatement = configuration.getMappedStatement("com.hcw.learn.mybatis.mapper.CourseMapper.selectAll");
    }


    @Test
    public void testJdbc() throws Exception{
        Connection connection =jdbcTransaction.getConnection();
    }

    @Test
    public void testJdbcPool() {
       DataSource dataSource =  sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
        System.out.println(dataSource.toString());
    }
}
