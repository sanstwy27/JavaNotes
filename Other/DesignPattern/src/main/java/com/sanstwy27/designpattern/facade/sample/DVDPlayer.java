package com.sanstwy27.designpattern.facade.sample;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class DVDPlayer {
    private static DVDPlayer instance = new DVDPlayer();

    private DVDPlayer() {

    }

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" dvd on ");
    }
    public void off() {
        System.out.println(" dvd off ");
    }

    public void play() {
        System.out.println(" dvd is playing ");
    }

    public void pause() {
        System.out.println(" dvd pause ..");
    }
}
