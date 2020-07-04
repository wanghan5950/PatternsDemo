package com.example.patterns.mediator;

/**
 * 中介者模式——抽象中介者
 */
public abstract class Mediator {

    /**
     * 用于在零部件对象改变时通知中介者，再由中介者通知其它零部件对象
     * @param component 零部件对象
     */
    public abstract void changed(Component component);
}
