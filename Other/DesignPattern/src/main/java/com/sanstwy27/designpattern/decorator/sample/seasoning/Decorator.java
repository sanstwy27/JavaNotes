package com.sanstwy27.designpattern.decorator.sample.seasoning;

import com.sanstwy27.designpattern.decorator.sample.drink.Drink;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Decorator extends Drink {
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        return super.getDes() + " " + getPrice() + " && " + obj.getDes();
    }
}
