package com.sanstwy27.designpattern.builder._jdk;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Example {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Hello, world");
        /**
         * 1. === [Director]
         * public final class StringBuilder
         *     extends AbstractStringBuilder
         *     ...
         *
         * 2. === [Builder]
         * abstract class AbstractStringBuilder implements Appendable, CharSequence {
         * ...
         *
         * 3. === [Abstract Builder]
         * public interface Appendable {
         *     ...
         *     Appendable append (CharSequence csq) throws IOException;
         *     ...
         *     Appendable append(CharSequence csq, int start, int end) throws IOException;
         *     ...
         *     Appendable append(char c) throws IOException;
         *     ...
         *
         */
        System.out.println(stringBuilder);
    }
}
