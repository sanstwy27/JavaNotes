package com.sanstwy27.designpattern.bridge;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class SlidePhone extends Phone {
    public SlidePhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        super.open();
        System.out.println(" => open SlidePhone ");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println(" => close SlidePhone ");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println(" => call SlidePhone ");
    }
}
