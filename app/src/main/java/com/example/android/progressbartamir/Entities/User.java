package com.example.android.progressbartamir.Entities;

/**
 * Created by tamir on 24/08/17.
 */

public class User {
    private String _name;
    private String _lustName;
    private short _age;
    private int _salary;

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

    public short get_age() {
        return _age;
    }

    public void set_age(int _age) {
        this._age = (short) _age;
    }

    public int get_salary() {
        return _salary;
    }

    public void set_salary(int _salary) {
        this._salary = _salary;
    }
}
