package com.sanstwy27.designpattern.proxy.staticproxy;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        teacherDaoProxy.teach();
        /**
         * Proxy start...
         *  teaching
         * Proxy end...
         */
    }
}
