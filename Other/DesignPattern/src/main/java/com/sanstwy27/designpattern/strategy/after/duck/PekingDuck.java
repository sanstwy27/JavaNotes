package com.sanstwy27.designpattern.strategy.after.duck;

import com.sanstwy27.designpattern.strategy.after.behavior.BadFlyBehavior;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class PekingDuck extends Duck {
    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("Peking Duck");
    }
}
