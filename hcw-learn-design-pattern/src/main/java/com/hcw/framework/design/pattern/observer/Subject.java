package com.hcw.framework.design.pattern.observer;

/**
 * 被观察者
 */
public interface Subject {

    public void addObserver(Observer observer);

    public void removeObsever(Observer observer);

    public void notifyObserver();
}
