package com.sanstwy27.designpattern.memento.game;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Caretaker {
    // -- save 1 state for 1 role --
    private Memento  memento;
    // -- save n state for 1 role --
    // private ArrayList<Memento> mementos;
    // -- save n state for n role --
    // private HashMap<String, ArrayList<Memento>> rolesMementos;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
