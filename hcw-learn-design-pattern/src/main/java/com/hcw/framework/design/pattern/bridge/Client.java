package com.hcw.framework.design.pattern.bridge;

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