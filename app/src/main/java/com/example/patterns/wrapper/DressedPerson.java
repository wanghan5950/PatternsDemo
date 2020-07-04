package com.example.patterns.wrapper;

/**
 * 装饰模式——要穿不同衣服的人
 */
public abstract class DressedPerson extends Person {

    //持有一个Person的引用
    protected Person person;

    public DressedPerson(Person person) {
        this.person = person;
    }

    @Override
    public void dressed() {
        person.dressed();
    }
}
