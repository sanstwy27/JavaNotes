package com.sanstwy27.designpattern.iterator.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class InfoCollege implements College {
    List<Department> departmentList;

    public InfoCollege() {
        departmentList = new ArrayList<Department>();
        addDepartment("I1", " InfoCollege Course 1 ");
        addDepartment("I2", " InfoCollege Course 2 ");
        addDepartment("I3", " InfoCollege Course 3 ");
    }

    @Override
    public String getName() {
        return "InfoCollege";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departmentList.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoColleageIterator(departmentList);
    }
}
