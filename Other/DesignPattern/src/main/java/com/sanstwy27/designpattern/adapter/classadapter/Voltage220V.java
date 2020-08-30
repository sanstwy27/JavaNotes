package com.sanstwy27.designpattern.adapter.classadapter;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Voltage220V {
    public int output220V() {
        int src = 220;
        System.out.println("Voltage=" + src + "V");
        return src;
    }
}
