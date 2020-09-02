package com.sanstwy27.designpattern.interpreter.sample;

import java.util.HashMap;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public abstract class Expression {
    // HashMap = {a = 10, b = 20, ...}
    // interpret
    public abstract int interpreter(HashMap<String, Integer> var);
}
