package com.example.patterns.visitor;

import java.util.Random;

/**
 * 访问者模式——工程师
 */
public class Engineer extends Staff {

    private int codeCount;

    public Engineer(String name) {
        super(name);
        codeCount = new Random().nextInt(10) * 10000;
    }

    public int getCodeCount() {
        return codeCount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
