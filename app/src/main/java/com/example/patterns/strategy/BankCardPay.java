package com.example.patterns.strategy;

/**
 * 具体策略类
 */
public class BankCardPay implements PayStrategy {

    @Override
    public boolean pay() {
        System.out.println("pay by bank card successful");
        return true;
    }
}
