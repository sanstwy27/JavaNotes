package com.sanstwy27.beans;

/**
 * @author Sanstwy27
 * @create 8/18/2020
 */

public class Book {
    String isbn;
    String name;
    Double price;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
