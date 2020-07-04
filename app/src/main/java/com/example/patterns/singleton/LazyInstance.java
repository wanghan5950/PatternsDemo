package com.example.patterns.singleton;

/**
 * 单例模式——懒汉模式
 */
public class LazyInstance {

    private static LazyInstance instance;

    private LazyInstance() {
    }

    /**
     * 通过synchronized保证了多线程调用时对象的唯一性，但每次调用时都会进行同步，会消耗不必要的资源
     * @return
     */
    public static synchronized LazyInstance getInstance() {
        if (instance == null) {
            instance = new LazyInstance();
        }
        return instance;
    }
}
