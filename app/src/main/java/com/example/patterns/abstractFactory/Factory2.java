package com.example.patterns.abstractFactory;

/**
 * 具体工厂2，用于生产2类产品
 */
public class Factory2 extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
