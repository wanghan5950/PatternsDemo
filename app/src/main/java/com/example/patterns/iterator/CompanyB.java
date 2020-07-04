package com.example.patterns.iterator;

/**
 * 迭代器模式——公司B，数组维护
 */
public class CompanyB implements Company {

    private Employee[] employees;

    public CompanyB() {
        employees = new Employee[4];
        employees[0] = new Employee("E", 24, "woman", "employee5");
        employees[1] = new Employee("F", 27, "man", "employee6");
        employees[2] = new Employee("G", 22, "woman", "employee7");
        employees[3] = new Employee("H", 21, "man", "employee8");
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator(employees);
    }
}
