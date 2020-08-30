package com.sanstwy27.designpattern.builder.after;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println(" HighBuilding buildBasic() ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" HighBuilding buildWalls() ");
    }

    @Override
    public void roofed() {
        System.out.println(" HighBuilding roofed() ");
    }
}
