package com.sanstwy27.designpattern.bridge;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Samsung implements Brand {
    @Override
    public void open() {
        System.out.println(" Samsung open ");
    }

    @Override
    public void close() {
        System.out.println(" Samsung close ");
    }

    @Override
    public void call() {
        System.out.println(" Samsung call ");
    }
}
