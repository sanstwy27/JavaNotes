package com.sanstwy27.designpattern.bridge;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Client {
    public static void main(String[] args) {
        Phone phone1 = new FoldedPhone(new Samsung());

        phone1.open();
        phone1.call();
        phone1.close();

        System.out.println("=======================");

        Phone phone2 = new FoldedPhone(new Sony());

        phone2.open();
        phone2.call();
        phone2.close();

        System.out.println("=======================");

        SlidePhone phone3 = new SlidePhone(new Samsung());

        phone3.open();
        phone3.call();
        phone3.close();

        System.out.println("=======================");

        SlidePhone phone4 = new SlidePhone(new Sony());

        phone4.open();
        phone4.call();
        phone4.close();

        /**
         *  Samsung open
         *  => open FoldedPhone
         *  Samsung call
         *  => call FoldedPhone
         *  Samsung close
         *  => close FoldedPhone
         * =======================
         *  Sony open
         *  => open FoldedPhone
         *  Sony call
         *  => call FoldedPhone
         *  Sony close
         *  => close FoldedPhone
         * =======================
         *  Samsung open
         *  => open SlidePhone
         *  Samsung call
         *  => call SlidePhone
         *  Samsung close
         *  => close SlidePhone
         * =======================
         *  Sony open
         *  => open SlidePhone
         *  Sony call
         *  => call SlidePhone
         *  Sony close
         *  => close SlidePhone
         *
         */
    }
}
