package com.sanstwy27.designpattern.factory.simplefactory.order.after;

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

    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        String orderType = "";

        this.simpleFactory = simpleFactory;

        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);

            if(pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" order failed ");
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
