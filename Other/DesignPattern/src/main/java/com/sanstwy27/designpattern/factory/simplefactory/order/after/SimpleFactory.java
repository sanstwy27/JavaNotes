package com.sanstwy27.designpattern.factory.simplefactory.order.after;

import com.sanstwy27.designpattern.factory.simplefactory.pizza.CheesePizza;
import com.sanstwy27.designpattern.factory.simplefactory.pizza.GreekPizza;
import com.sanstwy27.designpattern.factory.simplefactory.pizza.PepperPizza;
import com.sanstwy27.designpattern.factory.simplefactory.pizza.Pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class SimpleFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("SimpleFactory::createPizza");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" GreekPizza ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" CheesePizza ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName(" PepperPizza ");
        }
        return pizza;
    }

    public static Pizza createPizza2(String orderType) {
        Pizza pizza = null;
        System.out.println("SimpleFactory::createPizza2");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" GreekPizza ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" CheesePizza ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName(" PepperPizza ");
        }
        return pizza;
    }
}
