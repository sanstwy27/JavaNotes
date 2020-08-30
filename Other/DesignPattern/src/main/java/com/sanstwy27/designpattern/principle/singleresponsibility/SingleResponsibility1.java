package com.sanstwy27.designpattern.principle.singleresponsibility;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle1 vehicle = new Vehicle1();
        vehicle.run("Motorcycle");
        vehicle.run("Car");
        vehicle.run("Airplane"); // -><-

        /**
         * Motorcycle is running on road....
         * Car is running on road....
         * Airplane is running on road....
         */
    }


}

class Vehicle1 {
    public void run(String vehicle) {
        System.out.println(vehicle + " is running on road....");
    }
}