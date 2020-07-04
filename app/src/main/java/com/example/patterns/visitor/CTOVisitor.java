package com.example.patterns.visitor;

/**
 * 访问者模式——访问者
 */
public class CTOVisitor implements Visitor {

    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.getName() + "，代码行数：" + engineer.getCodeCount());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.getProducts() + "，产品数量：" + manager.getProducts());
    }
}
