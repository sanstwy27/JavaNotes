package com.sanstwy27.designpattern.facade.sample;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Stereo {
    private static Stereo instance = new Stereo();

    private Stereo() {

    }

    public static Stereo getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" Stereo on ");
    }

    public void off() {
        System.out.println(" Screen off ");
    }

    public void up() {
        System.out.println(" Screen up.. ");
    }

    //...
}
