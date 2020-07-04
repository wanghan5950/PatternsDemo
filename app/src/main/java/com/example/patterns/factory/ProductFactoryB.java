package com.example.patterns.factory;

public class ProductFactoryB extends ProductFactory {

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
