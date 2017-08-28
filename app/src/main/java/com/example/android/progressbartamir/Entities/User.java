package com.example.android.progressbartamir.Entities;

/**
 * Created by tamir on 24/08/17.
 */

public class User {
    private String _name;
    private String _lustName;
    private String _age;
    private String _salary;

    public User() {
        _name = "";
        _lustName = "";
        _age = "";
        _salary = "";
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_lustName() {
        return _lustName;
    }

    public void set_lustName(String _lustName) {
        this._lustName = _lustName;
    }

    public String get_age() {
        return _age;
    }

    public void set_age(String _age) {
        this._age = _age;
    }

    public String get_salary() {
        return _salary;
    }

    public void set_salary(String _salary) {
        this._salary = _salary;
    }
}
