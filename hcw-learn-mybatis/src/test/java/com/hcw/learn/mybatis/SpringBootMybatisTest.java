package com.hcw.learn.mybatis;

import com.hcw.learn.mybatis.entity.Course;
import com.hcw.learn.mybatis.mapper.CourseMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private   Logger LOG = LoggerFactory.getLogger(SpringBootMybatisTest.class);


    @Autowired
    private CourseMapper courseMapper;



    @Test
    public void save(){
        Course course = new Course();
        course.setCourseName("英语");
        course.setUserId(1l);
        course.setCourseClass("语言类");
        course.setCover("封面");
        course.setCourseCode("00001");
        course.setFinished(Short.valueOf("1"));
        courseMapper.insert(course);
    }


    @Test
    public void getOne()
    {
        Course course = courseMapper.getOne(2l);
        LOG.info("{}",course);
    }

}
