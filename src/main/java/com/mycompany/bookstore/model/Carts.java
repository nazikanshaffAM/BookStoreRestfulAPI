/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.model;

/**
 *
 * @author Nk
 */
public class Carts {
    
    private int bookId;
    private int quantity;
    private int customerId;
    
    public Carts() {
    }
    
    public Carts(int bookId, int quantity, int customerId) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.customerId = customerId;
    }
    
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
}
