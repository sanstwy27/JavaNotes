package com.sanstwy27.designpattern._uml.composition;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Person {
    // Aggregation
    private IDCard card;
    // Composition
    private Head head = new Head();
}
