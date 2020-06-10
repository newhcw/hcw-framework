package com.hcw.framework.design.pattern.facade;

/**
 * 外观模式：是结构性模式
 * 屏蔽了子系统的实现细节
 * 给系统外部调用提供了统一的门口，类似于gateway
 * 但是 不实现逻辑，只负责转发，与中介者模式不同
 */
public class SystemFacade {

    SystemA systemA;
    SystemB systemB;

    public void run() {
        systemA.run();
    }

    public void log() {
        systemB.log();
    }


}
