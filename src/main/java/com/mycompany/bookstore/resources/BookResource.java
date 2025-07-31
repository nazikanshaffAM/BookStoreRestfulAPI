/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.resources;

/**
 *
 * @author Nk
 */

import com.mycompany.bookstore.dao.AuthorDAO;
import com.mycompany.bookstore.exceptions.AuthorNotFoundException;
import com.mycompany.bookstore.exceptions.InvalidInputException;
import com.mycompany.bookstore.dao.BookDAO;
import com.mycompany.bookstore.exceptions.BookNotFoundException;
import com.mycompany.bookstore.model.Books;
import java.time.Year;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private final BookDAO bookDao = new BookDAO(); 
    private final AuthorDAO authordao = new AuthorDAO();
    
    @GET
    public Response getAllBooks(){
        
            List<Books> getBooks = bookDao.getAllBook();
            return Response.ok(getBooks).build();
        
    }
    
    @POST
    public Response addBooks(Books book){
        if(authordao.getAuthorById(book.getAuthorId()) == null){
            throw new AuthorNotFoundException(" *ERROR* Author not found by id: " + book.getAuthorId());
        }
        
        int currentYear = Year.now().getValue();
        if(book.getPublicationYear() > currentYear){
            throw new InvalidInputException(" *ERROR* Publication year is invalid. ");
        }
            bookDao.addBook(book);
            return Response.status(Response.Status.CREATED).build();
        
        
    }
    
    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") int id){
        
            Books book = bookDao.getBookById(id);
            if(book != null){
                return Response.ok(book).build();
            }else{
                throw new BookNotFoundException(" *ERROR* Book with Id: " + id + " Not found");
            }
        
    }
    
    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") int id, Books updateBook){
       
            updateBook.setId(id);
            boolean updated = bookDao.updateBook(updateBook);
            if(!updated ){
                throw new BookNotFoundException(" *ERROR* Book with Id: " + id + " Not found");
            }
            return Response.ok().build();
        
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id){
        
            boolean deleted = bookDao.deleteBookById(id);
            if(!deleted){
                throw new BookNotFoundException(" *ERROR* Book with Id: " + id + " Not found");
            }
            return Response.ok().build();
        
    }
    
}
