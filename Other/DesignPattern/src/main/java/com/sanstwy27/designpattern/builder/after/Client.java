package com.sanstwy27.designpattern.builder.after;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Client {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        House house = houseDirector.constructHouse();

        System.out.println("--------------------------");

        HighBuilding highBuilding = new HighBuilding();
        houseDirector.setHouseBuilder(highBuilding);
        houseDirector.constructHouse();

        /**
         *  CommonHouse buildBasic()
         *  CommonHouse buildWalls()
         *  CommonHouse roofed()
         * --------------------------
         *  HighBuilding buildBasic()
         *  HighBuilding buildWalls()
         *  HighBuilding roofed()
         */
    }
}