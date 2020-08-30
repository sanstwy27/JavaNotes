package com.sanstwy27.designpattern.adapter.objectadapter;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));

        /**
         * Voltage=220V
         * Adapted, output 5V
         * Voltage equals 5V, rechargeable.
         */
    }
}
