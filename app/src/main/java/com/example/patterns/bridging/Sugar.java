package com.example.patterns.bridging;

/**
 * 桥接模式——要加的东西实现，加糖
 */
public class Sugar extends CoffeeAdditives {

    @Override
    public String addSomething() {
        return "加糖";
    }
}
