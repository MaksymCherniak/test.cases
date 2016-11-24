package com.paazl.cases.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int score = 0;
    @SuppressWarnings("serial")
    private static final Map<String, Character> QUESTIONS = new HashMap<String, Character>() {
        {
            put("A Thread is a process", 'N');
            put("A List cannot contain duplicates", 'N');
            put("A Set can contain duplicates", 'N');
            put("Java is platform independent", 'Y');
            put("Java supports copy constructors like C++", 'Y');
            put("The primitive data types supported by the Java programming language are: byte, short, int, long, float, double, boolean, char", 'Y');
            put("Constructor overloading is similar to method overloading in Java", 'N');
            put("The purpose of garbage collection in Java is to reclaim and reuse objects which are no longer used", 'Y');
            put("Autoboxing is the automatic conversion made by the Java compiler between the primitive types and their corresponding object wrapper classes", 'Y');
            put("JDBC is an abstraction layer that allows users to choose between databases", 'Y');
            put("Java supports the usage of pointers", 'N');
        }
    };

    /*
     * Implement the main method:
     * * Show the user the questions on a console and collect the answers.
     * * If the user scores 0-3 points, print "You are a junior Java developer".
     * * If the user scores 4-7 points, print "You are a medior Java developer".
     * * If the user scores 8-10 points, print "You are a senior Java developer".
     */
    public static void main(String[] args) {
        printResult(executeTest());
    }

    public static int executeTest() {
        Iterator<Map.Entry<String, Character>> iterator = QUESTIONS.entrySet().iterator();
        String answer;

        System.out.println("Good day, you'll see the questions right here and you need to answer them using only Y(Yes)/N(No).");
        System.out.println();

        try {
            while (iterator.hasNext()) {
                Map.Entry<String, Character> entry = iterator.next();

                System.out.println(entry.getKey());
                answer = reader.readLine();

                while (true) {
                    if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("Y")) {
                        break;
                    }

                    System.out.println("Wrong answer format. Please enter Y(Yes)/N(No).");
                    System.out.println(entry.getKey());
                    answer = reader.readLine();
                }

                if (answer.equalsIgnoreCase(String.valueOf(entry.getValue()))) {
                    score++;
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return score;
    }

    private static void printResult(int score) {
        switch (getIndex(score)) {
            case 1:
                System.out.println("Your score is " + score + " points. You are a junior Java developer");
                break;
            case 2:
                System.out.println("Your score is " + score + " points. You are a middle Java developer");
                break;
            case 3:
                System.out.println("Your score is " + score + " points. You are a senior Java developer");
                break;
        }
    }

    private static int getIndex(int score) {
        if (score >= 0 && score <= 3) {
            return 1;
        }

        if (score >= 4 && score <= 7) {
            return 2;
        }

        return 3;
    }
}