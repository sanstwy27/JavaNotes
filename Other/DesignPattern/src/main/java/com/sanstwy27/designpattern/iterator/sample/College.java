package com.sanstwy27.designpattern.iterator.sample;

import java.util.Iterator;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public interface College {
    public String getName();
    public void addDepartment(String name, String desc);
    public Iterator createIterator();
}
