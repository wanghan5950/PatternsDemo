package com.example.patterns.builder;

public class Client {

    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder().build();
        System.out.println(computer.toString());
        AppleMac appleMac = new AppleMac.AppleMacBuilder().build();
        System.out.println(appleMac.toString());
    }
}
