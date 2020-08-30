package com.sanstwy27.designpattern._principle.liskov.before;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("-----------------------");
        B b = new B();
        System.out.println("11-3=" + b.func1(11, 3)); // override -><-
        System.out.println("1-8=" + b.func1(1, 8));   // override -><-
        System.out.println("11+3+9=" + b.func2(11, 3));

        /**
         * 11-3=8
         * 1-8=-7
         * -----------------------
         * 11-3=14
         * 1-8=9
         * 11+3+9=23
         */
    }
}

class A {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends A {
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}