package com.sanstwy27.designpattern.state.sample;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class DispenseOutState extends State {
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("the event is over");
    }

    @Override
    public boolean raffle() {
        System.out.println("the event is over");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("the event is over");
    }
}
