package com.example.patterns.visitor;

/**
 * 访问者模式——访问者接口
 */
public interface Visitor {

    void visit(Engineer engineer);

    void visit(Manager manager);
}
