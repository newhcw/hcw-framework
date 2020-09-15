package com.hcw.learn.mybatis;

import com.hcw.learn.mybatis.entity.Course;
import com.hcw.learn.mybatis.mapper.CourseMapper;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class MybatsiTest {

    public static void main(String[] args) throws IOException {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        DataSourceFactory dataSourceFactory = new UnpooledDataSourceFactory();
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        dataSourceFactory.setProperties(properties);
        DataSource dataSource = dataSourceFactory.getDataSource();
        Environment environment = new Environment("dev",transactionFactory,dataSource);
        Configuration cfg = new Configuration(environment);
        cfg.addMapper(CourseMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(cfg);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Course course = sqlSession.selectOne("com.hcw.learn.mybatis.mapper.CourseMapper.getOne",1l);
        System.out.println(course);
    }

}
