/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.dao;

/**
 *
 * @author Nk
 */


import com.mycompany.bookstore.model.Authors;
 
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class AuthorDAO {
    
    private static final List<Authors> authors = new ArrayList<>();
    private static final AtomicInteger authorId = new AtomicInteger(0);
    
    public List<Authors> getAllAuthors(){
        return authors;
    }
    
    public Authors getAuthorById(int id){
        for(Authors author:authors){
            if(author.getId() == id){
                return author;
            }
        }
        return null;
    }
    
    public void addAuthor(Authors author){
        int id = authorId.incrementAndGet();
        author.setId(id);
        authors.add(author);
    }
    
    public boolean updateAuthor(Authors author){
        for(Authors author1:authors){
            if(author1.getId() == author.getId()){
                author1.setName(author.getName());
                author1.setBiography(author.getBiography());
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteAuthorById(int id){
         return authors.removeIf(author1 -> author1.getId() == id);
    }
    
}
