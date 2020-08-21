package com.hcw.framework.mybatis.plus.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlSourceBuilder {

    // String sql = "select * from user where id = #{id} and user_name=#{userName}"
    public SqlSource parse(String sql) {

        int startTagIndex = 0;

        List parameterList = new ArrayList<>();
        for (int i = startTagIndex; i < sql.length(); i++) {
            if (sql.charAt(i) == '#'){

            }
            if (sql.charAt(i) == '}'){
                parameterList.add(sql.substring(startTagIndex,i));
                startTagIndex = i;
            }
        }


        StaticSqlSource staticSqlSource = new StaticSqlSource();
        staticSqlSource.setSql(sql);
        return staticSqlSource;
    }

}
