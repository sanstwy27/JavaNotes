package com.sanstwy27.designpattern._principle.inversion.after;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new Discord());
        /**
         * Email message: hello,world
         * Discord message: hello,ok
         */
    }
}

interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    public String getInfo() {
        return "Email message: hello,world";
    }
}

class Discord implements IReceiver {
    public String getInfo() {
        return "Discord message: hello,ok";
    }
}

class Person {
    public void receive(IReceiver receiver ) {
        System.out.println(receiver.getInfo());
    }
}