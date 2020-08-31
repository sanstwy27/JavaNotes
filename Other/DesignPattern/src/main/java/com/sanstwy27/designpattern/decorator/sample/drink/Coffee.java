package com.sanstwy27.designpattern.decorator.sample.drink;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
