package com.sanstwy27.designpattern.builder.before;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public abstract class AbstractHouse {

    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
