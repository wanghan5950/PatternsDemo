package com.example.patterns.strategy;

/**
 * 具体策略类
 */
public class AliPay implements PayStrategy {

    @Override
    public boolean pay() {
        System.out.println("pay by Ali successful");
        return true;
    }
}
