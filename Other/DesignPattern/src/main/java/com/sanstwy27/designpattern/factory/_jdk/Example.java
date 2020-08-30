package com.sanstwy27.designpattern.factory._jdk;

import java.util.Calendar;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Example {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        /**
         * ....
         *
         *     public static Calendar getInstance()
         *     {
         *         Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
         *         return createCalendar(defaultTimeZone(aLocale), aLocale);
         *     }
         *
         *     ...
         *
         *     private static Calendar createCalendar(TimeZone zone,
         *                                            Locale aLocale)
         *     {
         *         ...
         *         if (aLocale.hasExtensions()) {
         *             String caltype = aLocale.getUnicodeLocaleType("ca");
         *             if (caltype != null) {
         *                 switch (caltype) {
         *                 case "buddhist":
         *                 cal = new BuddhistCalendar(zone, aLocale);
         *                     break;
         *                 case "japanese":
         *                     cal = new JapaneseImperialCalendar(zone, aLocale);
         *                     break;
         *                 case "gregory":
         *                     cal = new GregorianCalendar(zone, aLocale);
         *                     break;
         *                 }
         *             }
         *         }
         *
         *         ...
         *
         *     }
         *
         * ....
         *
         */
        System.out.println("YEAR:" + cal.get(Calendar.YEAR));
        System.out.println("MONTH:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("DAY:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("HOUR:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE:" + cal.get(Calendar.MINUTE));
        System.out.println("SECOND:" + cal.get(Calendar.SECOND));
    }
}
