package com.sanstwy27.designpattern.mediator;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Alarm alarm = new Alarm(mediator, "alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffeeMachine");
        Curtains curtains = new Curtains(mediator, "curtains");
        TV tV = new TV(mediator, "TV");

        alarm.SendAlarm(0);
        coffeeMachine.FinishCoffee();
        alarm.SendAlarm(1);

        /**
         * It's time to startcoffee!
         * It's time to StartTv!
         * After 5 minutes!
         * Coffee is ok!
         * I am holding Up Curtains!
         * StopTv!
         *
         */
    }
}
