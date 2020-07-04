package com.example.patterns.template;

/**
 * 模板方法模式——具体实现类
 */
public class CorporateComputer extends AbstractComputer {

    @Override
    protected void loadOS() {
        super.loadOS();
        System.out.println("企业计算机——检查系统防火墙");
    }

    @Override
    protected void login() {
        super.login();
        System.out.println("企业计算机——验证账户权限");
    }
}
