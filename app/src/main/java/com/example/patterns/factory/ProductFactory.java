package com.example.patterns.factory;

/**
 * 工厂模式
 */
public abstract class ProductFactory {

    /**
     * 定义抽象工厂方法，具体工厂实现
     * @return
     */
    public abstract Product createProduct();
}
