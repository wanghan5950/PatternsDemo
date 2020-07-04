package com.example.patterns.observer.simpleImpl;

import java.util.Observable;

/**
 * 观察者模式——被观察者
 */
public class DevTechFrontier extends Observable {

    public void postNewPublication(String content) {
        //标识状态发生改变，并通知所有观察者
        setChanged();
        notifyObservers(content);
    }
}
