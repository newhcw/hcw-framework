package com.hcw.learn.guava;

import com.google.common.collect.ImmutableList;


import java.util.List;

public class Constants {

    public final static String DEPLOY_COMPANY_ID = "com.miotech.deploy.company.id";
    public final static String DEPLOY_ENV_ID = "com.miotech.deploy.env.id";
    public static final List<User> edgeTypesAll = List.of(
            new User(),
            new User()
    );

    public static void main(String[] args) {
        edgeTypesAll.add(new User());
    }
}
