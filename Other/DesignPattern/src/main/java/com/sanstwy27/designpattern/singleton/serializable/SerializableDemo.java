package com.sanstwy27.designpattern.singleton.serializable;

import java.io.*;

/**
 * @author Sanstwy27
 * @create 9/6/2020
 */

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("instance"));
        objectOutputStream.writeObject(instance);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("instance"));
        Object object = objectInputStream.readObject();
        objectInputStream.close();

        Singleton instance2 = ((Singleton) object);
        System.out.println(instance == instance2);
    }
}
