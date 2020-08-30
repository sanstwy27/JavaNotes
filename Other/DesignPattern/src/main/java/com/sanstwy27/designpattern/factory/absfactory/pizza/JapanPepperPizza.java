package com.sanstwy27.designpattern.factory.absfactory.pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class JapanPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("Japan PepperPizza");
        System.out.println(" Japan PepperPizza preparing...");
    }
}
