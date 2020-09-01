package com.sanstwy27.designpattern.template.type2;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Client {
    public static void main(String[] args) {
        System.out.println("---- Red Bean SoyMilk ----");
        SoyMilk redBeanSoyaMilk = new RedBeanSoyMilk();
        redBeanSoyaMilk.make();

        System.out.println("---- Peanut SoyMilk ----");
        SoyMilk peanutSoyaMilk = new PeanutSoyMilk();
        peanutSoyaMilk.make();

        System.out.println("---- Pure SoyMilk ----");
        PureSoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();

        /**
         * ---- Red Bean SoyMilk ----
         * step 1：select
         *  add red beans
         * step 3: soak
         * step 4：beat
         * ---- Peanut SoyMilk ----
         * step 1：select
         *  add peanut
         * step 3: soak
         * step 4：beat
         * ---- Pure SoyMilk ----
         * step 1：select
         * step 3: soak
         * step 4：beat
         *
         */
    }
}
