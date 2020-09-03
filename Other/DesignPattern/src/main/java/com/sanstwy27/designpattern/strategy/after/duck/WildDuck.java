package com.sanstwy27.designpattern.strategy.after.duck;

import com.sanstwy27.designpattern.strategy.after.behavior.GoodFlyBehavior;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class WildDuck extends Duck {
    public  WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println(" Wild Duck ");
    }
}
