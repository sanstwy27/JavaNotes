package com.sanstwy27.designpattern.strategy.after.duck;

import com.sanstwy27.designpattern.strategy.after.behavior.NoFlyBehavior;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class ToyDuck extends Duck {
    public ToyDuck() {
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("Toy Duck");
    }

    @Override
    public void quack() {
        System.out.println("Toy Duck can't quack");
    }

    @Override
    public void swim() {
        System.out.println("Toy Duck can't swim");
    }
}
