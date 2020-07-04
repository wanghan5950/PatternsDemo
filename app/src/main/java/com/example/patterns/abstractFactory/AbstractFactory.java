package com.example.patterns.abstractFactory;

/**
 * 抽象工厂模式——抽象工厂类
 */
public abstract class AbstractFactory {

    /**
     * 创建产品A抽象方法
     * @return
     */
    public abstract AbstractProductA createProductA();

    /**
     * 创建产品B抽象方法
     * @return
     */
    public abstract AbstractProductB createProductB();
}
