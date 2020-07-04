package com.example.patterns.bridging;

/**
 * 桥接模式——咖啡添加物
 */
public abstract class CoffeeAdditives {

    /**
     * 定义要往咖啡中添加什么
     * @return 添加的东西
     */
    public abstract String addSomething();
}
