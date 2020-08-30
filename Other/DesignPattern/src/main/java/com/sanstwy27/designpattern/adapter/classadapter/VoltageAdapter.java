package com.sanstwy27.designpattern.adapter.classadapter;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        int srcV = output220V();
        // To 5V
        int dstV = srcV / 44 ;
        return dstV;
    }
}
