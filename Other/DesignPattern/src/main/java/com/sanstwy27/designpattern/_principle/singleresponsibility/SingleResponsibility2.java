package com.sanstwy27.designpattern._principle.singleresponsibility;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("Motorcycle");
        roadVehicle.run("Car");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("Airplane");

        /**
         * Motorcycle is running on road....
         * Car is running on road....
         * Airplane is flying....
         */
    }


}

class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " is running on road....");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " is flying....");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " is driving on water....");
    }
}