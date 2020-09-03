package com.sanstwy27.designpattern.strategy.after.behavior;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println(" can't fly well ");
    }
}
