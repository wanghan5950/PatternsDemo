package com.example.patterns.bridging;

/**
 * 桥接模式——大杯咖啡
 */
public class LargeCoffee extends Coffee {

    public LargeCoffee(CoffeeAdditives coffeeAdditives) {
        super(coffeeAdditives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的" + coffeeAdditives + "咖啡");
    }
}
