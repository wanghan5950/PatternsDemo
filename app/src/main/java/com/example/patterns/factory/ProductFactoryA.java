package com.example.patterns.factory;

public class ProductFactoryA extends ProductFactory {

    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
