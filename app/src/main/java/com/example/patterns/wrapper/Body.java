package com.example.patterns.wrapper;

/**
 * 装饰模式——人实现类，实现穿衣方法
 */
public class Body extends Person {

    @Override
    public void dressed() {
        //定义人的基础逻辑
        System.out.println("穿内衣内裤");
    }
}
