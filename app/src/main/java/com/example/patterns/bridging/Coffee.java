package com.example.patterns.bridging;

/**
 * 桥接模式——咖啡抽象类
 */
public abstract class Coffee {

    //持有咖啡添加物的抽象引用
    protected CoffeeAdditives coffeeAdditives;

    public Coffee(CoffeeAdditives coffeeAdditives) {
        this.coffeeAdditives = coffeeAdditives;
    }

    /**
     * 实现此方法制作不同的咖啡
     */
    public abstract void makeCoffee();
}
