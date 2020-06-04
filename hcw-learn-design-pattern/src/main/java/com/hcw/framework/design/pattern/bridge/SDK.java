package com.hcw.framework.design.pattern.bridge;

import lombok.Data;
import lombok.Setter;

@Setter
public abstract class SDK {

    private SDKLogin sdkLogin;
    private SDKCreate sdkCreate;
    private SDKPublish sdkPublish;
    private SDKStart sdkStart;

    void init() {
        sdkLogin.login();//登录
        sdkStart.start();//启动逻辑
        sdkCreate.create();//创建
        sdkPublish.publish();//发布
    }


}