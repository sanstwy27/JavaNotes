package com.sanstwy27.designpattern.iterator.sample;

import java.util.Iterator;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class ComputerCollege implements College {
    Department[] departments;
    int numOfDepartment = 0;

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("C1", " ComputerCollege Course 1 ");
        addDepartment("C2", " ComputerCollege Course 2 ");
        addDepartment("C3", " ComputerCollege Course 3 ");
    }

    @Override
    public String getName() {
        return "ComputerCollege";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartment] = department;
        numOfDepartment += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
