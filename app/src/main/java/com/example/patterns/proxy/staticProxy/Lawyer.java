package com.example.patterns.proxy.staticProxy;

/**
 * 代理模式——代理人
 */
public class Lawyer implements ILawsuit {

    //持有一个被代理者的引用
    private ILawsuit litigant;

    public Lawyer(ILawsuit litigant) {
        this.litigant = litigant;
    }

    @Override
    public void submit() {
        litigant.submit();
    }

    @Override
    public void burden() {
        litigant.burden();
    }

    @Override
    public void defend() {
        litigant.defend();
    }

    @Override
    public void finish() {
        litigant.finish();
    }
}
