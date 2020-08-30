package com.sanstwy27.designpattern._principle.singleresponsibility;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("Motorcycle");
        vehicle.run("Car");
        vehicle.runAir("Airplane");

        /**
         * Motorcycle is running on road....
         * Car is running on road....
         * Airplane is flying....
         */
    }


}

class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + " is running on road....");

    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + " is flying....");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + " is driving on water....");
    }
}
