package com.sanstwy27.designpattern.factory.factorymethod.pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class LondonPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("London PepperPizza");
        System.out.println(" London PepperPizza preparing...");
    }
}
