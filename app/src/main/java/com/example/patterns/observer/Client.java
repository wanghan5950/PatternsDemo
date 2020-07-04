package com.example.patterns.observer;

import com.example.patterns.observer.simpleImpl.Coder;
import com.example.patterns.observer.simpleImpl.DevTechFrontier;

public class Client {

    public static void main(String[] args) {
        DevTechFrontier frontier = new DevTechFrontier();

        Coder coder1 = new Coder("coder_1");
        Coder coder2 = new Coder("coder_2");
        Coder coder3 = new Coder("coder_3");

        //将观察者注册到被观察者的观察者列表中
        frontier.addObserver(coder1);
        frontier.addObserver(coder2);
        frontier.addObserver(coder3);

        //发布消息
        frontier.postNewPublication("new weekly news has been published!");
    }
}
