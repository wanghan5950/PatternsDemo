package com.example.patterns.apperaance;

/**
 * 外观模式——Phone接口实现
 */
public class PhoneImpl implements Phone {

    @Override
    public void call() {
        System.out.println("打电话");
    }

    @Override
    public void hangup() {
        System.out.println("挂断");
    }
}
