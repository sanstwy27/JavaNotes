package com.sanstwy27.designpattern.template.type2;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class PureSoyaMilk extends SoyMilk {
    @Override
    void addCondiments() {

    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
