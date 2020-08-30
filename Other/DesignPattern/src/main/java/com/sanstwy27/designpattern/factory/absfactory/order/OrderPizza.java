package com.sanstwy27.designpattern.factory.absfactory.order;

import com.sanstwy27.designpattern.factory.absfactory.pizza.Pizza;

import java.util.Scanner;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class OrderPizza {
    AbsFactory factory;

    public OrderPizza(AbsFactory factory) {
        setFactory(factory);
    }

    private void setFactory(AbsFactory factory) {
        Pizza pizza = null;
        String orderType = "";
        this.factory = factory;
        do {
            orderType = getType();

            // factory had been injected
            pizza = factory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("order failed");
                break;
            }
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
