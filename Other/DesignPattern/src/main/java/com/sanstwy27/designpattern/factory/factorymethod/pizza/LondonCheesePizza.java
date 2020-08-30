package com.sanstwy27.designpattern.factory.factorymethod.pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class LondonCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("London CheesePizza");
        System.out.println(" London CheesePizza preparing...");
    }
}
