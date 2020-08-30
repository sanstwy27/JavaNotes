package com.sanstwy27.designpattern.factory.simplefactory.pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" CheesePizza preparing...");
    }
}
