package com.paazl.cases.test2;

public class Main {
    /*
     * Implement a main method that is functionally identical to Test #1. In
     * this case, use a DeveloperFactory that is able to produce 3 types of
     * developers that implement a "print" method. The Factory should have a
     * create method that takes the user's score as an argument.
     */
    public static void main(String[] args) {
        int score = com.paazl.cases.test1.Main.executeTest();

        DeveloperFactory.create(score).print();
    }
}