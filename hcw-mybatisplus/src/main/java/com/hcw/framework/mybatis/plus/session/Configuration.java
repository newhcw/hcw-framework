package com.hcw.framework.mybatis.plus.session;

import com.hcw.framework.mybatis.plus.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private Map<String, MappedStatement> mappedStatements = new HashMap<>();

    public static String url = "jdbc:mysql://47.100.240.207:5555/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&generateSimpleParameterMetadata=true";
    public static String user = "root";
    public static String password = "Root@123";

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public void addMapperStatement(MappedStatement mappedStatement) {
        mappedStatements.put(mappedStatement.getId(),mappedStatement);

    }
}
