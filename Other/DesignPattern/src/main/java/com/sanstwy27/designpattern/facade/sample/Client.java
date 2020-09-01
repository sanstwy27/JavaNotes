package com.sanstwy27.designpattern.facade.sample;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Client {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        System.out.println("---------");
        homeTheaterFacade.ready();
        System.out.println("---------");
        homeTheaterFacade.play();
        System.out.println("---------");
        homeTheaterFacade.end();
    }
}
