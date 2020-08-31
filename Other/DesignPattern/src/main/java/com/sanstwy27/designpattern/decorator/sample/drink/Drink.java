package com.sanstwy27.designpattern.decorator.sample.drink;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public abstract class Drink {
    public String des;
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
