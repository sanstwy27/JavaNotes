package com.sanstwy27.designpattern.factory.simplefactory;

//import com.sanstwy27.designpattern.factory.simplefactory.order.before.OrderPizza;
import com.sanstwy27.designpattern.factory.simplefactory.order.after.OrderPizza2;
import com.sanstwy27.designpattern.factory.simplefactory.order.after.SimpleFactory;
import com.sanstwy27.designpattern.factory.simplefactory.order.after.OrderPizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class PizzaStore {
    public static void main(String[] args) {
        // Original
        //new OrderPizza();

        // SimpleFactory 1
        new OrderPizza(new SimpleFactory());

        // SimpleFactory 2
        new OrderPizza2();
    }
}
