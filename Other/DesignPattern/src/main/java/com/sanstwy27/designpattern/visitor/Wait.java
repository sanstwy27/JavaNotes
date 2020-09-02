package com.sanstwy27.designpattern.visitor;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(" man is yet to be determined ");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" woman is yet to be determined ");
    }
}
