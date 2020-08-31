package com.sanstwy27.designpattern.decorator.sample;

import com.sanstwy27.designpattern.decorator.sample.drink.DeCaf;
import com.sanstwy27.designpattern.decorator.sample.drink.Drink;
import com.sanstwy27.designpattern.decorator.sample.drink.LongBlack;
import com.sanstwy27.designpattern.decorator.sample.seasoning.Chocolate;
import com.sanstwy27.designpattern.decorator.sample.seasoning.Milk;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class CoffeeBar {
    public static void main(String[] args) {
        // 1. LongBlack
        Drink order = new LongBlack();
        System.out.println("cost1=" + order.cost());
        System.out.println("desc=" + order.getDes());

        // 2. order + milk
        order = new Milk(order);
        System.out.println("order + 1 milk, cost =" + order.cost());
        System.out.println("order + 1 milk, desc =" + order.getDes());

        // 3. order + chocolate
        order = new Chocolate(order);
        System.out.println("order + 1 milk + 1 chocolate, cost =" + order.cost());
        System.out.println("order + 1 milk + 1 chocolate, desc =" + order.getDes());

        // 3. order + chocolate
        order = new Chocolate(order);
        System.out.println("order + 1 milk + 2 chocolate, cost =" + order.cost());
        System.out.println("order + 1 milk + 2 chocolate, desc =" + order.getDes());

        System.out.println("===========================");

        Drink order2 = new DeCaf();

        System.out.println("order2 cost =" + order2.cost());
        System.out.println("order2 desc =" + order2.getDes());

        order2 = new Milk(order2);

        System.out.println("order2 + 1 milk cost =" + order2.cost());
        System.out.println("order2 + 1 milk desc =" + order2.getDes());

        /**
         * cost1=5.0
         * desc=longblack
         * order + 1 milk, cost =7.0
         * order + 1 milk, desc = Milk  2.0 && longblack
         * order + 1 milk + 1 chocolate, cost =10.0
         * order + 1 milk + 1 chocolate, desc = Chocolate  3.0 &&  Milk  2.0 && longblack
         * order + 1 milk + 2 chocolate, cost =13.0
         * order + 1 milk + 2 chocolate, desc = Chocolate  3.0 &&  Chocolate  3.0 &&  Milk  2.0 && longblack
         * ===========================
         * order2 cost =1.0
         * order2 desc =DeCaf
         * order2 + 1 milk cost =3.0
         * order2 + 1 milk desc = Milk  2.0 && DeCaf
         *
         */
    }
}
