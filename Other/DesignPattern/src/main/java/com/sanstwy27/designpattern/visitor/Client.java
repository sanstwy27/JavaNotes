package com.sanstwy27.designpattern.visitor;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        Success success = new Success();
        objectStructure.display(success);
        System.out.println("===============");

        Fail fail = new Fail();
        objectStructure.display(fail);
        System.out.println("===============");

        Wait wait = new Wait();
        objectStructure.display(wait);
        System.out.println("===============");

        /**
         *  a successful man
         *  a successful woman
         * ===============
         *  a failed man
         *  a failed woman
         * ===============
         *  man is yet to be determined
         *  woman is yet to be determined
         * ===============
         *
         */
    }
}
