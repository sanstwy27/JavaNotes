package com.sanstwy27.designpattern.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class ObjectStructure {
    private List<Person> persons = new LinkedList<>();

    public void attach(Person p) {
        persons.add(p);
    }

    public void detach(Person p) {
        persons.remove(p);
    }

    public void display(Action action) {
        for(Person p: persons) {
            p.accept(action);
        }
    }
}
