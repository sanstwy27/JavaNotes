package com.sanstwy27.designpattern.state.sample;

import java.util.Random;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class CanRaffleState extends State {
    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("already deducted");
    }

    @Override
    public boolean raffle() {
        System.out.println("raffling...");
        Random r = new Random();
        int num = r.nextInt(10);
        if(num == 0){
            activity.setState(activity.getDispenseState());
            return true;
        }else{
            System.out.println("the ticket has drawn no prize.");
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }

    @Override
    public void dispensePrize() {

    }
}
