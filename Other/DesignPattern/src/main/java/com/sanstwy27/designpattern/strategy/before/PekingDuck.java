package com.sanstwy27.designpattern.strategy.before;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class PekingDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Peking Duck");
    }

    @Override
    public void fly() {
        System.out.println("Peking Duck can't fly");
    }
}
