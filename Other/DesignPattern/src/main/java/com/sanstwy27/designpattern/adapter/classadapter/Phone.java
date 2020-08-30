package com.sanstwy27.designpattern.adapter.classadapter;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Phone {
    public void charging(IVoltage5V iVoltage5V) {
        if(iVoltage5V.output5V() == 5) {
            System.out.println("Voltage equals 5V, rechargeable.");
        } else if (iVoltage5V.output5V() > 5) {
            System.out.println("Higher than expected output voltage (5V), non-rechargeable.");
        }
    }
}
