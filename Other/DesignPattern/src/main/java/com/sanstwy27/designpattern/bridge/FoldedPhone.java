package com.sanstwy27.designpattern.bridge;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        super.open();
        System.out.println(" => open FoldedPhone ");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println(" => close FoldedPhone ");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println(" => call FoldedPhone ");
    }
}
