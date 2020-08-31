package com.sanstwy27.designpattern.decorator.sample.seasoning;

import com.sanstwy27.designpattern.decorator.sample.drink.Drink;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes(" Soy  ");
        setPrice(1.5f);
    }
}
