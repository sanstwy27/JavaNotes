package com.sanstwy27.designpattern.memento.game;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Client {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        gameRole.setVit(100);
        gameRole.setDef(100);

        System.out.println("==== before boss fight ====");
        gameRole.display();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("==== boss fight ====");
        gameRole.setDef(30);
        gameRole.setVit(30);
        gameRole.display();

        System.out.println("==== after boss fight ====");
        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        System.out.println("current state");
        gameRole.display();

        /**
         * ==== before boss fight ====
         * [current role] atk：100, def: 100
         * ==== boss fight ====
         * [current role] atk：30, def: 30
         * ==== after boss fight ====
         * current state
         * [current role] atk：100, def: 100
         *
         */
    }
}
