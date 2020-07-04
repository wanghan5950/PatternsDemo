package com.example.patterns.combination.transparentCombination;

/**
 * 透明的组合模式——抽象节点
 * 枝干节点和叶子节点具有相同的结构
 */
public abstract class Component {

    //节点名称
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    /**
     * 定义节点需要实现的方法
     */
    public abstract void invoke();

    /**
     * 添加子节点
     * @param child 子节点
     */
    public abstract void addChild(Component child);

    /**
     * 移除子节点
     * @param child 子节点
     */
    public abstract void removeChild(Component child);

    /**
     * 获取子节点
     * @param index 子节点下标
     * @return 子节点
     */
    public abstract Component getChild(int index);
}
