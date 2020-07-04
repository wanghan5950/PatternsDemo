package com.example.patterns.strategy;

/**
 * 运用某种策略去做此事
 */
public class PayManager {

    public static boolean pay(PayStrategy payStrategy) {
        System.out.println("do something");
        return payStrategy.pay();
    }
}
