package com.sanstwy27.designpattern.strategy.after.duck;

import com.sanstwy27.designpattern.strategy.after.behavior.FlyBehavior;
import com.sanstwy27.designpattern.strategy.after.behavior.QuackBehavior;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public abstract class Duck {
    // Strategy Interface
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

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
        // improve
        if(flyBehavior != null) {
            flyBehavior.fly();
        }
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
