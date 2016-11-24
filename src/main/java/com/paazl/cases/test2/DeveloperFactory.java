package com.paazl.cases.test2;

import com.paazl.cases.test2.entities.Developer;
import com.paazl.cases.test2.entities.JuniorDeveloper;
import com.paazl.cases.test2.entities.MiddleDeveloper;
import com.paazl.cases.test2.entities.SeniorDeveloper;

public class DeveloperFactory {
    private static JuniorDeveloper juniorDeveloper;
    private static MiddleDeveloper middleDeveloper;
    private static SeniorDeveloper seniorDeveloper;

    public static Developer create(int score) {
        if (score >= 0 && score <= 3) {
            return getJuniorDeveloperInstance();
        }

        if (score >= 4 && score <= 7) {
            return getMiddleDeveloperInstance();
        }

        return getSeniorDeveloperInstance();
    }

    public static Developer getJuniorDeveloperInstance() {
        if (juniorDeveloper == null) {
            juniorDeveloper = new JuniorDeveloper();
        }

        return juniorDeveloper;
    }

    public static Developer getMiddleDeveloperInstance() {
        if (middleDeveloper == null) {
            middleDeveloper = new MiddleDeveloper();
        }

        return middleDeveloper;
    }

    public static Developer getSeniorDeveloperInstance() {
        if (seniorDeveloper == null) {
            seniorDeveloper = new SeniorDeveloper();
        }

        return seniorDeveloper;
    }
}
