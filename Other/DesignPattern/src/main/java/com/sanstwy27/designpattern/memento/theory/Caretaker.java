package com.sanstwy27.designpattern.memento.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Caretaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
