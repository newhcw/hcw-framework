package com.hcw.framework.design.pattern.bridge;

import lombok.Setter;

@Setter
public abstract class SDK {

    protected SDKLogin sdkLogin;//策略模式这里用protected修饰,只能子类或者同包下类使用
    protected SDKCreate sdkCreate;
    protected SDKPublish sdkPublish;
    protected SDKStart sdkStart;

    abstract void init();


}