package com.sanstwy27.designpattern.factory.absfactory.order;

import com.sanstwy27.designpattern.factory.absfactory.pizza.LondonCheesePizza;
import com.sanstwy27.designpattern.factory.absfactory.pizza.LondonPepperPizza;
import com.sanstwy27.designpattern.factory.absfactory.pizza.Pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class LondonFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LondonCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LondonPepperPizza();
        }
        return pizza;
    }
}
