package com.sanstwy27.designpattern.proxy.staticproxy;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class TeacherDaoProxy implements ITeacherDao {
    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("Proxy start... ");
        target.teach();
        System.out.println("Proxy end... ");
    }
}
