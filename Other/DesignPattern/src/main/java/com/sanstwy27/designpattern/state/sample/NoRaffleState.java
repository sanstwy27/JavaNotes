package com.sanstwy27.designpattern.state.sample;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class NoRaffleState extends State {
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("pay $50 for a raffle ticket");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("no raffle ticket！");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("unqualified");
    }
}
