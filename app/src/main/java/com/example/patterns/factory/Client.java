package com.example.patterns.factory;

public class Client {

    public static void main(String[] args) {
        ProductFactory factory = new ProductFactoryA();
        Product product = factory.createProduct();
        product.work();
    }
}
