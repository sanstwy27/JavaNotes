package com.sanstwy27.designpattern.strategy.after;

import com.sanstwy27.designpattern.strategy.after.behavior.NoFlyBehavior;
import com.sanstwy27.designpattern.strategy.after.duck.PekingDuck;
import com.sanstwy27.designpattern.strategy.after.duck.ToyDuck;
import com.sanstwy27.designpattern.strategy.after.duck.WildDuck;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();

        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.fly();

        // change PekingDuck behavior
        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        System.out.println("flying ability of Peking duck:");
        pekingDuck.fly();

        /**
         *  fly well
         *  can't fly
         *  can't fly well
         * flying ability of Peking duck:
         *  can't fly
         *
         */
    }
}
