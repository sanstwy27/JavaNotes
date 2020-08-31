package com.sanstwy27.designpattern.decorator._jdk;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Example {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("d:\\abc.txt"));
        /**
         * 1.
         *   public class FileInputStream extends InputStream
         *
         * 2.
         *   public abstract class InputStream implements Closeable
         *
         * 3.
         *   public class FilterInputStream extends InputStream {  -> Decorator
         *       ...
         *       protected volatile InputStream in;                -> Be decorated
         *       ...
         *   }
         *
         * 4.
         *   public class DataInputStream extends FilterInputStream implements DataInput -> Concrete Decorator
         *
         *
         *
         * Note:
         * 1. InputStream === Drink
         * 2. FileInputStream === DeCaf, LongBlack
         * 3. FilterInputStream === Decorator
         * 4. DataInputStream === Milk, Soy
         *
         */
        System.out.println(dis.read());
        dis.close();
    }
}
