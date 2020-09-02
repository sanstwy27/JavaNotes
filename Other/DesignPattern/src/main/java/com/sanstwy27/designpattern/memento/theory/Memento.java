package com.sanstwy27.designpattern.memento.theory;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Memento {
    private String state;

    public Memento(String state) {
        super();
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
