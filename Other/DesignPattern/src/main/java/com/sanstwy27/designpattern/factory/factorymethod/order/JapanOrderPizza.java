package com.sanstwy27.designpattern.factory.factorymethod.order;

import com.sanstwy27.designpattern.factory.factorymethod.pizza.JapanCheesePizza;
import com.sanstwy27.designpattern.factory.factorymethod.pizza.JapanPepperPizza;
import com.sanstwy27.designpattern.factory.factorymethod.pizza.Pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class JapanOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new JapanCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new JapanPepperPizza();
        }
        return pizza;
    }
}
