package com.sanstwy27.designpattern.observer.after;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditions currentConditions = new CurrentConditions();
        GoogleSite googleSite = new GoogleSite();

        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(googleSite);

        System.out.println("notify all observers");
        weatherData.setData(10f, 100f, 30.3f);

        weatherData.removeObserver(currentConditions);

        System.out.println();
        System.out.println("notify all observers");
        weatherData.setData(10f, 100f, 30.3f);

        /**
         * notify all observers
         * *** Today mTemperature: 10.0 ***
         * *** Today mPressure: 100.0 ***
         * *** Today mHumidity: 30.3 ***
         * ==== Google Site ====
         * *** Today mTemperature: 10.0 ***
         * *** Today mPressure: 100.0 ***
         * *** Today mHumidity: 30.3 ***
         *
         * notify all observers
         * ==== Google Site ====
         * *** Today mTemperature: 10.0 ***
         * *** Today mPressure: 100.0 ***
         * *** Today mHumidity: 30.3 ***
         *
         */
    }
}
