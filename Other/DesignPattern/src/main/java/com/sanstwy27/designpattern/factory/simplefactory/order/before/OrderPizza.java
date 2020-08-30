package com.sanstwy27.designpattern.factory.simplefactory.order.before;

import com.sanstwy27.designpattern.factory.simplefactory.pizza.CheesePizza;
import com.sanstwy27.designpattern.factory.simplefactory.pizza.GreekPizza;
import com.sanstwy27.designpattern.factory.simplefactory.pizza.PepperPizza;
import com.sanstwy27.designpattern.factory.simplefactory.pizza.Pizza;

import java.util.Scanner;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class OrderPizza {

    // -><- OCP principle
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
                pizza.setName(" GreekPizza ");
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
                pizza.setName(" CheesePizza ");
            } else if (orderType.equals("pepper")) {
                pizza = new PepperPizza();
                pizza.setName(" PepperPizza ");
            } else {
                break;
            }

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        } while (true);
    }

    private String getType() {
        try {
            //BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            //System.out.println("input pizza type:");
            //String str = strin.readLine();
            //strin.close();

            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
