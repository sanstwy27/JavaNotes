package com.sanstwy27.designpattern.factory.factorymethod.order;

import com.sanstwy27.designpattern.factory.factorymethod.pizza.LondonCheesePizza;
import com.sanstwy27.designpattern.factory.factorymethod.pizza.LondonPepperPizza;
import com.sanstwy27.designpattern.factory.factorymethod.pizza.Pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class LondonOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new LondonCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LondonPepperPizza();
        }
        return pizza;
    }
}
