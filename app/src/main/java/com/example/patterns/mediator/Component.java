package com.example.patterns.mediator;

/**
 * 中介者模式——抽象零部件
 */
public abstract class Component {

    //每个零部件对象都知道其中介者
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
}
