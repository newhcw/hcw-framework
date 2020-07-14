package com.hcw.framework.design.pattern.observer;

/**
 * 观察者模式,解决的是一对多的问题
 */
public class Client {
    public static void main(String[] args) {
        Observer observer = () -> {
            System.out.println("a event change ");
        };

        Subject subject = new SubjectImpl();
        subject.addObserver(observer);
        subject.notifyObserver();
    }
}
