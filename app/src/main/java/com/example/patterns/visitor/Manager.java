package com.example.patterns.visitor;

import java.util.Random;

/**
 * 访问者模式——经理
 */
public class Manager extends Staff {

    private int products;

    public Manager(String name) {
        super(name);
        products = new Random().nextInt(10);
    }

    public int getProducts() {
        return products;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
