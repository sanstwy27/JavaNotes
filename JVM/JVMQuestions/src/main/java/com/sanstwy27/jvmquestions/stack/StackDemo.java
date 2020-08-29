package com.sanstwy27.jvmquestions.stack;

/**
 * @author Sanstwy27
 * @create 8/29/2020
 * @comment The Data Type of Stack Frames
 */

public class StackDemo {
    // 1. Method
    public int add(int x, int y) {
        // 2. Basic Variable Type
        int result = -1;
        result = x + y;
        return result;
    }

    public static void main(String[] args) {
        // 3. Reference Variable
        StackDemo stackDemo = new StackDemo();
    }
}
