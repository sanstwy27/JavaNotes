package com.sanstwy27.designpattern.factory.simplefactory.pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" PepperPizza preparing...");
    }
}
