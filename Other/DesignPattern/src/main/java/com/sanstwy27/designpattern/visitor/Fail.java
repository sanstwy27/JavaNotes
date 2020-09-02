package com.sanstwy27.designpattern.visitor;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Fail extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println(" a failed man ");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" a failed woman ");
    }
}
