package com.sanstwy27.designpattern.observer.before;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Client {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);

        weatherData.setData(30, 150, 40);
        System.out.println("============ Weather Change =============");
        weatherData.setData(40, 160, 20);

        /**
         * *** Today mTemperature: 30.0 ***
         * *** Today mPressure: 150.0 ***
         * *** Today mHumidity: 40.0 ***
         * ============ Weather Change =============
         * *** Today mTemperature: 40.0 ***
         * *** Today mPressure: 160.0 ***
         * *** Today mHumidity: 20.0 ***
         *
         */
    }
}
