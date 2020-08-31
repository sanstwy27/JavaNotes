package com.sanstwy27.designpattern.bridge;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Sony implements Brand {
    @Override
    public void open() {
        System.out.println(" Sony open ");
    }

    @Override
    public void close() {
        System.out.println(" Sony close ");
    }

    @Override
    public void call() {
        System.out.println(" Sony call ");
    }
}
