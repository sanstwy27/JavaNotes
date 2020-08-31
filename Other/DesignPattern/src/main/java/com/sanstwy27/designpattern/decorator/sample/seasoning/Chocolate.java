package com.sanstwy27.designpattern.decorator.sample.seasoning;

import com.sanstwy27.designpattern.decorator.sample.drink.Drink;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes(" Chocolate ");
        setPrice(3.0f);
    }
}
