package com.sanstwy27.designpattern.uml.aggregation;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Computer {
    private Mouse mouse;
    private Moniter moniter;

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setMoniter(Moniter moniter) {
        this.moniter = moniter;
    }
}
