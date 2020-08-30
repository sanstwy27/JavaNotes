package com.sanstwy27.designpattern.prototype.after.deepClone;

import java.io.*;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class DeepProtoType implements Serializable, Cloneable {
    // String
    public String name;
    // Object
    public DeepCloneableTarget deepCloneableTarget;

    public DeepProtoType() {
        super();
    }

    /**
     * Deep Clone 1 - clone()
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {

        Object deep = null;
        // Basic Type
        deep = super.clone();
        // Object Type
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

        return deepProtoType;
    }

    /**
     * Deep Clone 2 - Serialize (recommended)
     * @return
     */
    public Object deepClone() {

        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {

            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType) ois.readObject();

            return copyObj;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
}
