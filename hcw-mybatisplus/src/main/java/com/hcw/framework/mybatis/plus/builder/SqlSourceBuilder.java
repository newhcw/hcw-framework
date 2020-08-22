package com.hcw.framework.mybatis.plus.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlSourceBuilder {

    // String sql = "select * from user where id = #{id} and user_name=#{userName} and age=#{age} and school = #{school}"
    public SqlSource parse(String sql,String openToken, String closeToken,List parameterList) {

        int startAppend=0;
        int start = sql.indexOf(openToken);

        StringBuffer finalSql = new StringBuffer();
        for (int i = start; i < sql.length(); i++) {
            if (sql.charAt(i) == openToken.toCharArray()[0]){
                finalSql.append(sql.substring(startAppend,i)).append("?");
                startAppend = i;
            }
            if (sql.charAt(i) == closeToken.toCharArray()[0]){
                parameterList.add(sql.substring(startAppend+2,i));
                startAppend= i+1;
            }
        }


        StaticSqlSource staticSqlSource = new StaticSqlSource(finalSql.toString());
        return staticSqlSource;
    }

}
