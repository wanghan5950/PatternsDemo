package com.example.patterns.observer.simpleImpl;

import androidx.annotation.NonNull;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式——观察者
 */
public class Coder implements Observer {

    private String name;

    public Coder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hi, " + name + ", DevTechFrontier update news: " + arg);
    }

    @NonNull
    @Override
    public String toString() {
        return "Coder{" +
                "name='" + name + '\'' +
                '}';
    }
}
