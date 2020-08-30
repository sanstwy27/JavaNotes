package com.sanstwy27.designpattern.factory.factorymethod;

import com.sanstwy27.designpattern.factory.factorymethod.order.JapanOrderPizza;
import com.sanstwy27.designpattern.factory.factorymethod.order.LondonOrderPizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class PizzaStore {
    public static void main(String[] args) {
        String loc = "japan";
        if (loc.equals("japan")) {
            new JapanOrderPizza();
        } else {
            new LondonOrderPizza();
        }
    }
}
