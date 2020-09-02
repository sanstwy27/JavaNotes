package com.sanstwy27.designpattern.interpreter.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Client {
    public static void main(String[] args) throws IOException {
        // a + b
        String expStr = getExpStr();
        // var {a=10, b=20}
        HashMap<String, Integer> var = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println("Result：" + expStr + "=" + calculator.run(var));

        /**
         * please input expression：a+b+c
         * please input a value：1
         * please input b value：3
         * please input c value：7
         * Result：a+b+c=11
         *
         */
    }

    public static String getExpStr() throws IOException {
        System.out.print("please input expression：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static HashMap<String, Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();

        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.print("please input " + String.valueOf(ch) + " value：");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }

        return map;
    }
}
