package com.example.patterns.bridging;

/**
 * 桥接模式——小杯咖啡
 */
public class SmallCoffee extends Coffee {

    public SmallCoffee(CoffeeAdditives coffeeAdditives) {
        super(coffeeAdditives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯的" + coffeeAdditives + "咖啡");
    }
}
