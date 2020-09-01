package com.sanstwy27.designpattern.flyweight.sample;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class User {
    private String name;

    public User(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
