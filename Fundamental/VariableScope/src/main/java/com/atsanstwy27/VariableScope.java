package com.atsanstwy27;

/**
 * @author Sanstwy27
 * @create 8/17/2020
 */

public class VariableScope {
    static int s;
    int i;
    int j;
    {
        int i = 1;
        i++;
        j++;
        s++;
    }
    public void test(int j) {
        j++;
        i++;
        s++;
    }
    public static void main(String[] args) {
        VariableScope obj1 = new VariableScope();
        VariableScope obj2 = new VariableScope();
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);
        System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);
    }
}
