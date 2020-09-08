package com.sanstwy27.zookeeper.distributedlock.util;

/**
 * @author Sanstwy27
 * @create 9/8/2020
 */

public class OrderNumberCreateUtil {
    private static int num = 0;

    public static String getOrderNumber() {
        return "\t Generate Order Number：" + (++num);
    }
}
