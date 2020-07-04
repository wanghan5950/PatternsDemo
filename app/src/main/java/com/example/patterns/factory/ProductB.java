package com.example.patterns.factory;

public class ProductB extends Product {

    private String name = "DemoProductB";

    @Override
    public void work() {
        System.out.println("this is product B : " + name);
    }
}
