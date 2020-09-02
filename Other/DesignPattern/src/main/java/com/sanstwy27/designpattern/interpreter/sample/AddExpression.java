package com.sanstwy27.designpattern.interpreter.sample;

import java.util.HashMap;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
