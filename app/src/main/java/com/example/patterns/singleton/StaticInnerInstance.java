package com.example.patterns.singleton;

/**
 * 单例模式——静态内部类模式
 */
public class StaticInnerInstance {

    private StaticInnerInstance() {
    }

    /**
     * 只有第一次调用getInstance()方法时才会在静态内部类中初始化单例，既保证了线程安全，又实现了延迟加载
     * @return
     */
    public static StaticInnerInstance getInstance() {
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {
        private static final StaticInnerInstance instance = new StaticInnerInstance();
    }
}
