package com.sanstwy27.designpattern.factory.absfactory.pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class JapanCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("Japan CheesePizza");
        System.out.println(" Japan CheesePizza preparing...");
    }
}
