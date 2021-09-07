package com.hcw.learn.jvm.oom;

/**
 * 单例模式
 *
 * 饿汉式 懒汉式 双重检索式 内部类
 *
 */

public class SingleInstance {

    public static void main(String[] args) {

    }

}

class DoubleCheckLockSingleInstance {
    private static volatile DoubleCheckLockSingleInstance singleInstance = null;

    private DoubleCheckLockSingleInstance() {
    };

    public static DoubleCheckLockSingleInstance getInstance() {
        if (singleInstance == null) {
            synchronized (DoubleCheckLockSingleInstance.class) {
                if (singleInstance == null) {
                    singleInstance = new DoubleCheckLockSingleInstance();
                }
            }
        }
        return singleInstance;
    }

}

class HungrySingleInstance {

    private static HungrySingleInstance singleInstance = new HungrySingleInstance();

    private HungrySingleInstance() {

    }

    public static HungrySingleInstance getInstance() {
        return HungrySingleInstance.singleInstance;
    }
}

class StaticInnerClassSingleInstance {

    static class InstanceHolder {
        public static SingleInstance singleInstance = new SingleInstance();
    }

    public static SingleInstance getInstance(){
        return InstanceHolder.singleInstance;
    }

}
