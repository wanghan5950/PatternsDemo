package com.example.patterns.template;

public class Client {

    public static void main(String[] args) {
        AbstractComputer computer1 = new CommonComputer();
        computer1.start();

        AbstractComputer computer2 = new CorporateComputer();
        computer2.start();
    }
}
