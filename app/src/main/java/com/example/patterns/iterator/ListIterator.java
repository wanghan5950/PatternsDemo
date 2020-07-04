package com.example.patterns.iterator;

import java.util.List;

/**
 * 迭代器模式——用于List的迭代器
 */
public class ListIterator implements Iterator {

    private List<Employee> list;
    private int position;

    public ListIterator(List<Employee> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return !(position > list.size() - 1 || list.get(position) == null);
    }

    @Override
    public Object next() {
        Employee employee = list.get(position);
        position++;
        return employee;
    }
}
