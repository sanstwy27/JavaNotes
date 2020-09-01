package com.sanstwy27.designpattern.facade.sample;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Projector {
    private static Projector instance = new Projector();

    private Projector() {

    }

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" Projector on ");
    }

    public void off() {
        System.out.println(" Projector off ");
    }

    public void focus() {
        System.out.println(" Projector is Projector  ");
    }

    //...
}
