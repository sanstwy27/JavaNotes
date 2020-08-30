package com.sanstwy27.designpattern.factory.factorymethod.order;

import com.sanstwy27.designpattern.factory.factorymethod.pizza.Pizza;

import java.util.Scanner;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public abstract class OrderPizza {
    abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            pizza = createPizza(orderType);

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
