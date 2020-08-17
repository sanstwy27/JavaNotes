package com.sanstwy27.beans;

/**
 * @author Sanstwy27
 * @create 8/17/2020
 */

public class Book {
    String name;
    int pages;

    Book() {
        System.out.println("Book created.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
