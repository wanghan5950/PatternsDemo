package com.example.patterns.singleton;

/**
 * 单例模式——饿汉模式
 */
public class HungryInstance {

    private static HungryInstance instance = new HungryInstance();

    private HungryInstance() {
    }

    /**
     * 实例在声明时就会进行初始化
     * @return
     */
    public static HungryInstance getInstance() {
        return instance;
    }
}
