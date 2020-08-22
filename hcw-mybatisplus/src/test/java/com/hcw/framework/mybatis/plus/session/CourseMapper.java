package com.hcw.framework.mybatis.plus.session;

public interface CourseMapper {
    

    Course getOne(Long courseId);

    Course queryOne(Course course);


}