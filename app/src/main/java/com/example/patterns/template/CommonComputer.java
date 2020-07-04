package com.example.patterns.template;

/**
 * 模板方法模式——具体实现类
 */
public class CommonComputer extends AbstractComputer {

    @Override
    protected void login() {
        super.login();
        System.out.println("一般计算机——输入个人账户密码");
    }
}
