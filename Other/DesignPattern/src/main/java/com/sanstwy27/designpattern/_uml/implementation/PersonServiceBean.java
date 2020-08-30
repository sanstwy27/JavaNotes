package com.sanstwy27.designpattern._uml.implementation;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class PersonServiceBean implements PersonService {
    @Override
    public void delete(Integer id) {
        System.out.println("delete..");
    }
}
