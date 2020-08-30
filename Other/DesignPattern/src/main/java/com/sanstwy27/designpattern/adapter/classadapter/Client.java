package com.sanstwy27.designpattern.adapter.classadapter;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());

        /**
         * Voltage=220V
         * Voltage equals 5V, rechargeable.
         */
    }
}
