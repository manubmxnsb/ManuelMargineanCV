package ex3;

import ex2.Author;

public class Book {
    private String name;
    private double price;
    private Author author;
    private int qtyInStock;

    {
        qtyInStock = 0;
    }
    public Book(String name,Author author, double price){
        this.name = name;
        this.price = price;
        this.author = author;
    }
    public Book(String name,Author author, double price, int qtyInStock) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.qtyInStock = qtyInStock;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }
}
