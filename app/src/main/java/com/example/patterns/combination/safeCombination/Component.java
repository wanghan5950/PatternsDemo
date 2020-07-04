package com.example.patterns.combination.safeCombination;

/**
 * 组合模式——抽象根节点
 */
public abstract class Component {

    //节点名
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    /**
     * 定义节点需要实现的方法
     */
    public abstract void invoke();
}
