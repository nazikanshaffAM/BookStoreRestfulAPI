/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.dao;

/**
 *
 * @author Nk
 */


import com.mycompany.bookstore.model.Books;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BookDAO {
    
    private static final List<Books> books = new ArrayList<>();
    private static final AtomicInteger bookId = new AtomicInteger(0);
    
    public List<Books> getAllBook(){
        return books;
    }
    
    public Books getBookById(int id){
        for(Books book:books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }
    
    public void addBook(Books book){
        int id = bookId.incrementAndGet();
        book.setId(id);
        books.add(book);
    }
    
    public boolean updateBook(Books book){
        for(Books book1:books){
            if(book1.getId() == book.getId()){
                book1.setIsbn(book.getIsbn());
                book1.setPrice(book.getPrice());
                book1.setPublicationYear(book.getPublicationYear());
                book1.setStock(book.getStock());
                book1.setTitle(book.getTitle());
                book1.setAuthorId(book.getAuthorId());
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteBookById(int id){
        return books.removeIf(book1 -> book1.getId() == id);
    }
    
}
