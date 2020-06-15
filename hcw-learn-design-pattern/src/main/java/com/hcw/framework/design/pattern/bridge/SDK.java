package com.hcw.framework.design.pattern.bridge;

import lombok.Setter;

@Setter
public abstract class SDK {

    /**
     * 桥梁模式这里用protected修饰,只能子类或者同包下类使用
     */
    protected SDKLogin sdkLogin;
    protected SDKCreate sdkCreate;
    protected SDKPublish sdkPublish;
    protected SDKStart sdkStart;


    /**
     * 初始化方法
     */
    abstract void init();


}