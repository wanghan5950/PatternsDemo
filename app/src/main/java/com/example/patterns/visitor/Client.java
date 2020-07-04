package com.example.patterns.visitor;

public class Client {

    public static void main(String[] args) {
        BusinessReport report = new BusinessReport();
        report.showReport(new CEOVisitor());
        report.showReport(new CTOVisitor());
    }
}
