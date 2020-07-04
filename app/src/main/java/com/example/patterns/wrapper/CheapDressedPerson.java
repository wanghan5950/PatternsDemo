package com.example.patterns.wrapper;

/**
 * 装饰模式——穿便宜衣服的人
 */
public class CheapDressedPerson extends DressedPerson {

    public CheapDressedPerson(Person person) {
        super(person);
    }

    /**
     * 定义装饰方法
     */
    private void dressShorts() {
        System.out.println("穿短裤");
    }

    @Override
    public void dressed() {
        super.dressed();
        dressShorts();
    }
}
