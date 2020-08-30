package com.sanstwy27.designpattern.prototype.after.deepClone;

import java.io.Serializable;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class DeepCloneableTarget implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    // Because member variables are String , just clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
