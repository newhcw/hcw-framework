package com.hcw.learn.mybatis.entity;

import java.io.Serializable;

import lombok.Data;

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