package com.paazl.cases.test3;

import com.paazl.cases.test3.enums.Answers;

import java.util.HashMap;
import java.util.Map;

import static com.paazl.cases.test3.enums.Answers.*;

public class Singleton {
    private static Singleton singleton;

    private Singleton() {}

    private final Map<String, Answers> QUESTIONS = new HashMap<String, Answers>() {
        {
            put("A Thread is a process", N);
            put("A List cannot contain duplicates", N);
            put("A Set can contain duplicates", N);
            put("Java is platform independent", Y);
            put("Java supports copy constructors like C++", Y);
            put("The primitive data types supported by the Java programming language are: byte, short, int, long, float, double, boolean, char", Y);
            put("Constructor overloading is similar to method overloading in Java", N);
            put("The purpose of garbage collection in Java is to reclaim and reuse objects which are no longer used", Y);
            put("Autoboxing is the automatic conversion made by the Java compiler between the primitive types and their corresponding object wrapper classes", Y);
            put("JDBC is an abstraction layer that allows users to choose between databases", Y);
            put("Java supports the usage of pointers", N);
        }
    };

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }

    public Map<String, Answers> getQUESTIONS() {
        return QUESTIONS;
    }
}
