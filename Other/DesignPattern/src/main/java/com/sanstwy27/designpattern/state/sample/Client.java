package com.sanstwy27.designpattern.state.sample;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Client {
    public static void main(String[] args) {
        RaffleActivity activity = new RaffleActivity(1);

        for (int i = 0; i < 30; i++) {
            System.out.println("-------- #" + (i + 1) + " raffle----------");
            activity.deductMoney();
            activity.raffle();
        }

        /**
         * -------- #1 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #2 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #3 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #4 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #5 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #6 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #7 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #8 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #9 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #10 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #11 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #12 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #13 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #14 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #15 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #16 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #17 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #18 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #19 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #20 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #21 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #22 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #23 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * the ticket has drawn no prize.
         * -------- #24 raffle----------
         * pay $50 for a raffle ticket
         * raffling...
         * congratulations! you have won the prize.
         * -------- #25 raffle----------
         * the event is over
         * the event is over
         * -------- #26 raffle----------
         * the event is over
         * the event is over
         * -------- #27 raffle----------
         * the event is over
         * the event is over
         * -------- #28 raffle----------
         * the event is over
         * the event is over
         * -------- #29 raffle----------
         * the event is over
         * the event is over
         * -------- #30 raffle----------
         * the event is over
         * the event is over
         *
         */
    }
}
