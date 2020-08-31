package com.sanstwy27.designpattern.composite.sample.leaf;

import com.sanstwy27.designpattern.composite.sample.OrganizationComponent;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Department extends OrganizationComponent {
    public Department(String name, String des) {
        super(name, des);
    }

    // Leaf node without add , remove

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
