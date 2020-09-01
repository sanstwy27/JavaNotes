package com.sanstwy27.designpattern.proxy.dynamic;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Client {
    public static void main(String[] args) {
        ITeacherDao target = new TeacherDao();
        ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(target).getProxyInstance();
        // proxyInstance = class com.sun.proxy.$Proxy0, load proxy object dynamically in memory
        System.out.println("proxyInstance = " + proxyInstance.getClass());

        proxyInstance.teach();
        proxyInstance.sayHello(" Alice ");

        /**
         * proxyInstance = class com.sun.proxy.$Proxy0
         * JDK proxy start
         *  teaching
         * JDK proxy end
         * JDK proxy start
         *  hello  Alice
         * JDK proxy end
         */
    }
}
