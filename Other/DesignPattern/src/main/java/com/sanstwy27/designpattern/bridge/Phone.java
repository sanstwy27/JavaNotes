package com.sanstwy27.designpattern.bridge;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        super();
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        brand.close();
    }

    protected void call() {
        brand.call();
    }
}
