package com.sanstwy27.designpattern.state.sample;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class DispenseState extends State {
    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("can't deduct money");
    }

    @Override
    public boolean raffle() {
        System.out.println("can't raffle");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("congratulations! you have won the prize.");
            if (activity.getCount() == 0) {
                activity.setState(activity.getDispenseOutState());
            } else {
                activity.setState(activity.getNoRaffleState());
            }
        } else {
            System.out.println("sorry, the event is over.");
            activity.setState(activity.getDispenseOutState());
        }
    }
}
