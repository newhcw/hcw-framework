package com.hcw.framework.mybatis.plus.mapping;

/**
 * #{id,jdbcType=INTEGER,mode=IN}
 */
public class ParameterMapping {

    private String property;
    private ParameterMode mode;
    private Class<?> javaType = Object.class;
    private JdbcType jdbcType;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public ParameterMode getMode() {
        return mode;
    }

    public void setMode(ParameterMode mode) {
        this.mode = mode;
    }

    public Class<?> getJavaType() {
        return javaType;
    }

    public void setJavaType(Class<?> javaType) {
        this.javaType = javaType;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(JdbcType jdbcType) {
        this.jdbcType = jdbcType;
    }
}
