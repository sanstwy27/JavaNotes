package com.sanstwy27.designpattern.memento.theory;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState(" state#1 attack 100 ");
        caretaker.add(originator.saveStateMemento());

        originator.setState(" state#1 attack 80 ");
        caretaker.add(originator.saveStateMemento());

        originator.setState(" state#1 attack 50 ");
        caretaker.add(originator.saveStateMemento());

        System.out.println("current state = " + originator.getState());

        // restore
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println(" restore to state#1 ");
        System.out.println("current state = " + originator.getState());

        /**
         * current state =  state#1 attack 50
         *  restore to state#1
         * current state =  state#1 attack 100
         */
    }
}
