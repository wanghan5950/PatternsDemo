package com.example.patterns.wrapper;

public class Client {

    public static void main(String[] args) {
        Person person = new Body();

        ExpensiveDressedPerson expensiveDressedPerson = new ExpensiveDressedPerson(person);
        expensiveDressedPerson.dressed();

        CheapDressedPerson cheapDressedPerson = new CheapDressedPerson(person);
        cheapDressedPerson.dressed();
    }
}
