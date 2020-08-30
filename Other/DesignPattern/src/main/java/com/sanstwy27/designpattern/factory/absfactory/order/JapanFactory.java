package com.sanstwy27.designpattern.factory.absfactory.order;

import com.sanstwy27.designpattern.factory.absfactory.pizza.JapanCheesePizza;
import com.sanstwy27.designpattern.factory.absfactory.pizza.JapanPepperPizza;
import com.sanstwy27.designpattern.factory.absfactory.pizza.Pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class JapanFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new JapanCheesePizza();
        } else if (orderType.equals("pepper")){
            pizza = new JapanPepperPizza();
        }
        return pizza;
    }
}
