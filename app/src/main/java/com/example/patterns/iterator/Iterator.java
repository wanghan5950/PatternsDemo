package com.example.patterns.iterator;

/**
 * 迭代器模式——迭代器接口
 */
public interface Iterator {

    /**
     * 是否有下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 返回当前位置的元素，并将位置移到下一位
     */
    Object next();
}
