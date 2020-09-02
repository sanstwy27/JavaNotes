package com.sanstwy27.designpattern.interpreter.sample;

import java.util.HashMap;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
