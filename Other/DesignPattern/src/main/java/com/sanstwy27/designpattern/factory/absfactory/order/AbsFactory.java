package com.sanstwy27.designpattern.factory.absfactory.order;

import com.sanstwy27.designpattern.factory.absfactory.pizza.Pizza;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public interface AbsFactory {
    public Pizza createPizza(String orderType);
}
