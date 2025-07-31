/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.model;

/**
 *
 * @author Nk
 */
public class Books {
    
    private int id;
    private String title;
    private String isbn;
    private int authorId;
    private int publicationYear;
    private int stock;
    private double price;

    public Books() {
    }
 
    public Books(int id, String title, String isbn, int authorId, int publicationYear, int stock, double price) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.authorId = authorId;
        this.publicationYear = publicationYear;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int pubYear) {
        this.publicationYear = pubYear;
    }

    public int getStock() {
        return stock;
    }

    public void  setStock(int quantity) {
        this.stock = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
