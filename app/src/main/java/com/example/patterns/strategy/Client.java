package com.example.patterns.strategy;

public class Client {

    public static void main(String[] args) {
        boolean payResult = PayManager.pay(new AliPay());
        if (payResult) {
            System.out.println("pay successful");
        }
    }
}
