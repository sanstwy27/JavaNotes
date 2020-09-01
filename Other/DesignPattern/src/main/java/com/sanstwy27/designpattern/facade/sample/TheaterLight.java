package com.sanstwy27.designpattern.facade.sample;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class TheaterLight {
    private static TheaterLight instance = new TheaterLight();

    private TheaterLight() {

    }

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" TheaterLight on ");
    }

    public void off() {
        System.out.println(" TheaterLight off ");
    }

    public void dim() {
        System.out.println(" TheaterLight dim.. ");
    }

    public void bright() {
        System.out.println(" TheaterLight bright.. ");
    }
}
