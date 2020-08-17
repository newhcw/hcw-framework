package com.hcw.framework.mybatis.plus.session;

import com.hcw.framework.mybatis.plus.mapping.MappedStatement;
import com.hcw.framework.mybatis.plus.mapping.SqlCommandType;
import com.hcw.framework.mybatis.plus.session.defaults.DefaultSqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DefaultSqlSessionTest {


    @Test
    public void testQuery() {

        Configuration configuration = new Configuration();
        MappedStatement mappedStatement = new MappedStatement();
        mappedStatement.setId("com.hcw.framework.mybatis.plus.session.CourseMapper.getOne");
        mappedStatement.setSql("SELECT * FROM t_course WHERE course_id = 1");
        configuration.addMapperStatement(mappedStatement);


        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        SqlSession  sqlSession = defaultSqlSessionFactory.openSession();
        Object selectone = sqlSession.selectone("com.hcw.framework.mybatis.plus.session.CourseMapper.getOne", Long.valueOf("1"));
        System.out.println(selectone);
    }

    @Test
    public void testMapper() {
        Configuration configuration = new Configuration();
        MappedStatement mappedStatement = new MappedStatement();
        mappedStatement.setSqlCommandType(SqlCommandType.SELECT);
        mappedStatement.setId("com.hcw.framework.mybatis.plus.session.CourseMapper.getOne");
        mappedStatement.setSql("SELECT * FROM t_course WHERE course_id = 1");

        configuration.addMapperStatement(mappedStatement);

        configuration.addMapper(CourseMapper.class);


        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        SqlSession  sqlSession = defaultSqlSessionFactory.openSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        Course course = courseMapper.getOne(1l);
        Assertions.assertNotNull(course);
    }
}