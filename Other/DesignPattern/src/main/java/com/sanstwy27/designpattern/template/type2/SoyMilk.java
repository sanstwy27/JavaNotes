package com.sanstwy27.designpattern.template.type2;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public abstract class SoyMilk {
    final void make() {
        select();
        if(customerWantCondiments()) {
            addCondiments();
        }
        soak();
        beat();
    }

    void select() {
        System.out.println("step 1：select  ");
    }

    abstract void addCondiments();

    void soak() {
        System.out.println("step 3: soak ");
    }

    void beat() {
        System.out.println("step 4：beat  ");
    }

    // Hook
    boolean customerWantCondiments() {
        return true;
    }
}
