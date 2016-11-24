package com.paazl.cases.test6.entities;

import java.time.LocalDate;

public class User {
    private String name;
    private String city;
    private String country;
    private int number;
    private LocalDate date;

    public User() {
    }

    public User(String name, String city, String country, int number, LocalDate date) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.number = number;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return name + ";" + city + ";" + country + ";" + number + ";" + date;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        if (number != user.number) return false;
        if (!name.equals(user.name)) return false;
        if (!city.equals(user.city)) return false;
        return country.equals(user.country);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + number;
        return result;
    }
}
