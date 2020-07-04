package com.example.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式——公司A，列表维护
 */
public class CompanyA implements Company {

    private List<Employee> employeeList;

    public CompanyA() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("A", 25, "man", "employee1"));
        employeeList.add(new Employee("B", 22, "woman", "employee2"));
        employeeList.add(new Employee("C", 23, "woman", "employee3"));
        employeeList.add(new Employee("D", 26, "man", "employee4"));
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator(employeeList);
    }
}
