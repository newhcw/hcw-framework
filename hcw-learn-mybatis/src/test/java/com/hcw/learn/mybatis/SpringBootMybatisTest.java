package com.hcw.learn.mybatis;

import static org.junit.Assert.assertTrue;

import com.hcw.learn.mybatis.mapper.CourseMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootMybatisApplication.class})
public class SpringBootMybatisTest 
{

    @Autowired
    CourseMapper courseMapper;

    @Test
    public void shouldAnswerWithTrue()
    {
        courseMapper.getOne(1l);
    }
}
