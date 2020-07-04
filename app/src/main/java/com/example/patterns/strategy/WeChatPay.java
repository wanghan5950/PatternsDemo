package com.example.patterns.strategy;

/**
 * 具体策略类
 */
public class WeChatPay implements PayStrategy {

    @Override
    public boolean pay() {
        System.out.println("pay by WeChat successful");
        return true;
    }
}
