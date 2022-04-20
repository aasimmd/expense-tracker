package com.example.ExpenseTracker.model;

import lombok.ToString;

@ToString
public class Pie {
    public String name;
    public int value;

    public Pie(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
