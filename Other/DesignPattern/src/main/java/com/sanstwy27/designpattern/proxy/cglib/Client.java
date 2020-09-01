package com.sanstwy27.designpattern.proxy.cglib;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Client {
    public static void main(String[] args) {
        TeacherDao target = new TeacherDao();
        TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(target).getProxyInstance();

        // call method with proxy object => trigger intercept
        String res = proxyInstance.teach();
        System.out.println("res=" + res);

        /**
         * Cglib proxy start
         *  proxy with cglib
         * Cglib proxy end
         * res=hello
         */
    }
}
