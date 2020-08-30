package com.sanstwy27.designpattern.factory.absfactory.pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public abstract class Pizza {
    protected String name;

    public abstract void prepare();


    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
