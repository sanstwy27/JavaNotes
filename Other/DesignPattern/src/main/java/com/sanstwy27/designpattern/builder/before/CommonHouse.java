package com.sanstwy27.designpattern.builder.before;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class CommonHouse extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println(" CommonHouse buildBasic() ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" CommonHouse buildWalls() ");
    }

    @Override
    public void roofed() {
        System.out.println(" CommonHouse roofed() ");
    }
}
