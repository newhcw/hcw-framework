package com.hcw.framework.mybatis.plus.binding;

import com.hcw.framework.mybatis.plus.session.Course;
import com.hcw.framework.mybatis.plus.session.CourseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapperProxyFactoryTest {

    @Test
    public void testInstance() {
        CourseMapper courseMapper = (CourseMapper) new MapperProxyFactory().newInstance(CourseMapper.class,null);
        Course course = courseMapper.getOne(1l);
        Assertions.assertNotNull(course);
    }

}