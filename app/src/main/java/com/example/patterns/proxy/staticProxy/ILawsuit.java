package com.example.patterns.proxy.staticProxy;

/**
 * 代理模式——代理诉讼
 */
public interface ILawsuit {

    /**
     * 定义要代理的方法
     */
    //提交申请
    void submit();

    //进行举证
    void burden();

    //开始辩护
    void defend();

    //诉讼完成
    void finish();
}
