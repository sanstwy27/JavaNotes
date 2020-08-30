package com.sanstwy27.designpattern.builder.before;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Client {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();

        /**
         *  CommonHouse buildBasic()
         *  CommonHouse buildWalls()
         *  CommonHouse roofed()
         */
    }
}
