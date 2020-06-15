package com.hcw.framework.design.pattern.bridge;

public class WBSDK extends SDK{

    @Override
    void init() {
        sdkLogin.login();//登录
        sdkStart.start();//启动逻辑
        sdkCreate.create();//创建
        sdkPublish.publish();//发布
    }
    
}