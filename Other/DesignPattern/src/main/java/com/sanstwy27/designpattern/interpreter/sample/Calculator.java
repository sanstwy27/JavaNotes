package com.sanstwy27.designpattern.interpreter.sample;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Calculator {
    private Expression expression;

    // expStr = a + b
    public Calculator(String expStr) {
        Stack<Expression> stack = new Stack<>();
        // [a, +, b]
        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;
        // iterate [a, +, b]
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    // left => "a"
                    left = stack.pop();
                    // right => "b"
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        // last Expression
        this.expression = stack.pop();
    }

    public int run(HashMap<String, Integer> var) {
        // HashMap = {a = 10, b = 20, ...}
        // interpret
        return this.expression.interpreter(var);
    }
}
