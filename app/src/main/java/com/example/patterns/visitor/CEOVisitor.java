package com.example.patterns.visitor;

/**
 * 访问者模式——访问者
 */
public class CEOVisitor implements Visitor {

    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.getName() + "，KPI：" + engineer.getKPI());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.getName() + "，KPI：" + manager.getKPI());
    }
}
