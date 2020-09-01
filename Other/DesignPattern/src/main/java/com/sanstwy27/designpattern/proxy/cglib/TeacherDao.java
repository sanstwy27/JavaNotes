package com.sanstwy27.designpattern.proxy.cglib;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class TeacherDao {
    public String teach() {
        System.out.println(" proxy with cglib ");
        return "hello";
    }
}
