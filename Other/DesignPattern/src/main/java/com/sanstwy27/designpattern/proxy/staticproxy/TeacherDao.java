package com.sanstwy27.designpattern.proxy.staticproxy;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println(" teaching ");
    }
}
