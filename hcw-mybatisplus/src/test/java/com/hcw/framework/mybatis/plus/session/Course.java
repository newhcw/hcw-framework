package com.hcw.framework.mybatis.plus.session;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable{

    private Long courseId;
    private String courseName;
    private Long userId;
    private String courseClass;
    private String cover;
    private String courseCode;
    private Short finished;
}