package com.sanstwy27.designpattern.prototype.after.deepClone;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType p = new DeepProtoType();
        p.name = "Alice";
        p.deepCloneableTarget = new DeepCloneableTarget("AA1", "AA2");

        // Deep Clone 1 - clone()
		DeepProtoType p2 = (DeepProtoType) p.clone();
		System.out.println("p.name=" + p.name + " p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
		System.out.println("p2.name=" + p.name + " p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());
        /**
         * p.name=Alice p.deepCloneableTarget=1342443276
         * p2.name=Alice p2.deepCloneableTarget=396180261
         */

        // Deep Clone 2 - Serialize (recommended)
        DeepProtoType p3 = (DeepProtoType) p.deepClone();
        System.out.println("p.name=" + p.name + " p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p3.name=" + p.name + " p3.deepCloneableTarget=" + p3.deepCloneableTarget.hashCode());
        /**
         * p.name=Alice p.deepCloneableTarget=1342443276
         * p3.name=Alice p3.deepCloneableTarget=1724731843
         */
    }
}
