package com.sanstwy27.jvmquestions.classloader;

/**
 * @author Sanstwy27
 * @create 8/29/2020
 */

public class ClassLoaderDemo {
    public static void main(String[] args) {
        // We can't get Bootstrap Loader, default is null.
        Object object = new Object();
        //System.out.println(object.getClass().getClassLoader().getParent().getParent());
        //System.out.println(object.getClass().getClassLoader().getParent());
        System.out.println(object.getClass().getClassLoader());

        System.out.println();
        System.out.println();
        System.out.println();

        ClassLoaderDemo classLoaderDemo = new ClassLoaderDemo();
        System.out.println(classLoaderDemo.getClass().getClassLoader().getParent().getParent());
        System.out.println(classLoaderDemo.getClass().getClassLoader().getParent());
        System.out.println(classLoaderDemo.getClass().getClassLoader());

        /**
         * null
         *
         *
         *
         * null
         * jdk.internal.loader.ClassLoaders$PlatformClassLoader@6f539caf
         * jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d
         */
    }
}
