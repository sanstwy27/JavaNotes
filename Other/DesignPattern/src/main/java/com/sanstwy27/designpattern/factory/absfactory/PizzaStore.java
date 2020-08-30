package com.sanstwy27.designpattern.factory.absfactory;

import com.sanstwy27.designpattern.factory.absfactory.order.JapanFactory;
import com.sanstwy27.designpattern.factory.absfactory.order.LondonFactory;
import com.sanstwy27.designpattern.factory.absfactory.order.OrderPizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class PizzaStore {
    public static void main(String[] args) {
        //new OrderPizza(new JapanFactory());
        new OrderPizza(new LondonFactory());
    }
}
