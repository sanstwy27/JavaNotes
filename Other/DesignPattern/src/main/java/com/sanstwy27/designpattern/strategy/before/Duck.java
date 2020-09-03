package com.sanstwy27.designpattern.strategy.before;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public abstract class Duck {
    public Duck() {

    }

    public abstract void display();

    public void quack() {
        System.out.println("Duck quack quack");
    }

    public void swim() {
        System.out.println("Duck swim");
    }

    public void fly() {
        System.out.println("Duck fly");
    }
}
