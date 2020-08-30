package com.sanstwy27.designpattern.uml.dependence;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class PersonServiceBean {
    private PersonDao personDao;

    public void save(Person person) {
    }

    public IDCard getIDCard(Integer personId) {
        return null;
    }

    public void modify() {
        Department department = new Department();
    }
}
