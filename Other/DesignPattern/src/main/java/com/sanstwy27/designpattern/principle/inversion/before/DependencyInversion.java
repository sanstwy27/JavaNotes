package com.sanstwy27.designpattern.principle.inversion.before;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        /**
         * message: hello,world
         */
    }
}

class Email {
    public String getInfo() {
        return "message: hello,world";
    }
}

class Person {
    public void receive(Email email ) {
        System.out.println(email.getInfo());
    }
}

