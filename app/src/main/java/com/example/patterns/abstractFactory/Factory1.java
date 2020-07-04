package com.example.patterns.abstractFactory;

/**
 * 具体工厂1，用于生产1类产品
 */
public class Factory1 extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
