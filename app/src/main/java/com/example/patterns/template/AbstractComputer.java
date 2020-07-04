package com.example.patterns.template;

/**
 * 模板方法模式
 */
public abstract class AbstractComputer {

    /**
     * 各个步骤的方法，具体实现类根据不同的需求有不同的实现
     */
    protected void powerOn() {
        System.out.println("打开电源");
    }

    protected void checkHardware() {
        System.out.println("检查硬件");
    }

    protected void loadOS() {
        System.out.println("启动操作系统");
    }

    protected void login() {
        System.out.println("登录用户");
    }

    /**
     * 定义模板方法，方法的执行顺序已经固定，不能被重写
     */
    public final void start() {
        System.out.println("---------------开机----------------");
        powerOn();
        checkHardware();
        loadOS();
        login();
        System.out.println("-------------开始使用--------------");
    }
}
