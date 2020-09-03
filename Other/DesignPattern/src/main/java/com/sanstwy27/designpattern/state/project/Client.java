package com.sanstwy27.designpattern.state.project;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new PublishState());
        System.out.println(context.getCurrentState());

        // publish --> not pay
        context.acceptOrderEvent(context);
        // not pay --> paid
        context.payOrderEvent(context);

        try {
        	context.checkFailEvent(context);
        	System.out.println("normal program flow");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

        /**
         * current state: PUBLISHED
         * PUBLISHED
         * current state: NOT_PAY
         * current state: PAID
         * not allowed
         *
         */
    }
}
