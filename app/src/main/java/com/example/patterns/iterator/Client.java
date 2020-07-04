package com.example.patterns.iterator;

public class Client {

    public static void main(String[] args) {
        Company companyA = new CompanyA();
        Company companyB = new CompanyB();

        checkEmployee(companyA.iterator());
        checkEmployee(companyB.iterator());
    }

    private static void checkEmployee(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
