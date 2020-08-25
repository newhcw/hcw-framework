package com.hcw.framework.mybatis.plus.builder;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SqlSourceBuilderTest {


    @Test
    public void testSql() {
        SqlSourceBuilder sqlSourceBuilder = new SqlSourceBuilder();
        SqlSource parse = sqlSourceBuilder.parse("select * from user where id = ${id} and user_name=${userName}  and age=${age} ","${","}",new ArrayList());
        String sql = "select * from user where id = ? and user_name=?  and age=?";
        Assertions.assertEquals(sql,parse.getBoundSql(null));
    }

    @Test
    public void testChar() {
        char a = '\\';
        Assertions.assertEquals('\\',a);
    }

}
