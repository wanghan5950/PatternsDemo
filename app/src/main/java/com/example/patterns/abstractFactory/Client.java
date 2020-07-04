package com.example.patterns.abstractFactory;

public class Client {

    public static void main(String[] args) {
        Factory1 factory1 = new Factory1();
        ProductA1 productA1 = (ProductA1) factory1.createProductA();
        ProductB1 productB1 = (ProductB1) factory1.createProductB();
        productA1.work();
        productB1.play();
    }
}
