package com.sanstwy27.designpattern.visitor;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
