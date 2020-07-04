package com.example.patterns.visitor;

import java.util.Random;

/**
 * 访问者模式——员工基类
 */
public abstract class Staff {

    private String name;
    private int KPI;

    public Staff(String name) {
        this.name = name;
        this.KPI = new Random().nextInt(10);
    }

    public String getName() {
        return name;
    }

    public int getKPI() {
        return KPI;
    }

    public abstract void accept(Visitor visitor);
}
