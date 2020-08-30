package com.sanstwy27.designpattern.adapter.objectadapter;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class VoltageAdapter implements IVoltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220v) {
        this.voltage220V = voltage220v;
    }

    @Override
    public int output5V() {
        int dstV = 0;
        if(null != voltage220V) {
            int srcV = voltage220V.output220V();
            // To 5V
            dstV = srcV / 44;
            System.out.println("Adapted, output 5V");
        }
        return dstV;
    }
}
