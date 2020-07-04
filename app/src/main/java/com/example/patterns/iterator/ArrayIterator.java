package com.example.patterns.iterator;

/**
 * 迭代器模式——用于数组的迭代器
 */
public class ArrayIterator implements Iterator {

    private Employee[] employees;
    private int position;

    public ArrayIterator(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public boolean hasNext() {
        return !(position > employees.length - 1 || employees[position] == null);
    }

    @Override
    public Object next() {
        Employee employee = employees[position];
        position++;
        return employee;
    }
}
