package com.sanstwy27.designpattern.observer.after;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class GoogleSite implements Observer {
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("==== Google Site ====");
        System.out.println("*** Today mTemperature: " + temperature + " ***");
        System.out.println("*** Today mPressure: " + pressure + " ***");
        System.out.println("*** Today mHumidity: " + humidity + " ***");
    }
}
