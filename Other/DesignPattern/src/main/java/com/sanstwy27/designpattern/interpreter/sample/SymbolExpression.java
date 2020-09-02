package com.sanstwy27.designpattern.interpreter.sample;

import java.util.HashMap;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
