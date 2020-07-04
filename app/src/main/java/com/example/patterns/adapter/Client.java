package com.example.patterns.adapter;

public class Client {

    public static void main(String[] args) {
        VoltAdapter adapter = new VoltAdapter(new Volt220());
        System.out.println(adapter.getVolt5());
    }
}
