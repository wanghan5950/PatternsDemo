package com.example.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式——员工报表
 */
public class BusinessReport {

    private List<Staff> staffList = new ArrayList<>();

    public BusinessReport() {
        staffList.add(new Engineer("EngineerA"));
        staffList.add(new Engineer("EngineerB"));
        staffList.add(new Engineer("EngineerC"));
        staffList.add(new Manager("ManagerA"));
        staffList.add(new Manager("ManagerB"));
        staffList.add(new Manager("ManagerC"));
    }

    /**
     * 为访问者展示报表
     * @param visitor
     */
    public void showReport(Visitor visitor) {
        for (Staff staff : staffList) {
            staff.accept(visitor);
        }
    }
}
