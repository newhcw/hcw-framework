package com.hcw.framework.design.pattern.bridge;

/**
 * 桥接模式,有点像模板模式+ 策略模式
 * 不过这个模式,可以同时满足设计模式的7大原则:
 * 里氏替换,依赖倒置,单一职责,合成聚合,迪米特,开闭原则,接口隔离
 * 
 * 
 */
public class Client {

    public static void main(String[] args) {
        SDK wbsdk = new WBSDK();
        // wbsdk.setSdkLogin(sdkLogin);
        // wbsdk.setSdkCreate(sdkCreate);
        // wbsdk.setSdkPublish(sdkPublish);
        // wbsdk.setSdkStart(sdkStart);
        wbsdk.init();
    }
    
}