package com.example.patterns.bridging;

/**
 * 桥接模式——要加的东西实现，原为
 */
public class Ordinary extends CoffeeAdditives {

    @Override
    public String addSomething() {
        return "原为";
    }
}
