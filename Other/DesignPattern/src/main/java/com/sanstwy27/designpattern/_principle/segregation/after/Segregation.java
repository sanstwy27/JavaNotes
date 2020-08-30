package com.sanstwy27.designpattern._principle.segregation.after;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Segregation {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());

        /**
         * B implements operation1
         * B implements operation2
         * B implements operation3
         * D implements operation1
         * D implements operation4
         * D implements operation5
         */
    }
}

interface Interface1 {
    void operation1();

}

interface Interface2 {
    void operation2();

    void operation3();
}

interface Interface3 {
    void operation4();

    void operation5();
}

class B implements Interface1, Interface2 {
    public void operation1() {
        System.out.println("B implements operation1");
    }

    public void operation2() {
        System.out.println("B implements operation2");
    }

    public void operation3() {
        System.out.println("B implements operation3");
    }

}

class D implements Interface1, Interface3 {
    public void operation1() {
        System.out.println("D implements operation1");
    }

    public void operation4() {
        System.out.println("D implements operation4");
    }

    public void operation5() {
        System.out.println("D implements operation5");
    }
}

class A {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface2 i) {
        i.operation2();
    }

    public void depend3(Interface2 i) {
        i.operation3();
    }
}

class C {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface3 i) {
        i.operation4();
    }

    public void depend5(Interface3 i) {
        i.operation5();
    }
}