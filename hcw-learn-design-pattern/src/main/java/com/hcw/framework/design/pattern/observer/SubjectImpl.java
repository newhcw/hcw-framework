package com.hcw.framework.design.pattern.observer;

import java.util.Vector;

public class SubjectImpl implements Subject {

    Vector<Observer> observers = new Vector<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObsever(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(o->{
            o.update();
        });
    }
}
