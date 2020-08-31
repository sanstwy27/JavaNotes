package com.sanstwy27.designpattern.decorator.sample.seasoning;

import com.sanstwy27.designpattern.decorator.sample.drink.Drink;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes(" Milk ");
        setPrice(2.0f);
    }
}
