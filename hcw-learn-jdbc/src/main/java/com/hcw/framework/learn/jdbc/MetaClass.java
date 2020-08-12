package com.hcw.framework.learn.jdbc;

import lombok.Getter;
import lombok.ToString;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Getter
@ToString
public class MetaClass {

    private List<Constructor> constructors;
    private List<Field> declaredFields;
    private List<Method> declaredMethods;

    public  MetaClass(Class clazz) {
        constructors = Arrays.asList(clazz.getConstructors());
        declaredFields = Arrays.asList(clazz.getDeclaredFields());
        declaredMethods = Arrays.asList(clazz.getDeclaredMethods());
    }
}
